package miu.edu.cs489;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String fName;
    private String lName;
    private LocalDate employementDate;
    private Double yearlySalary;
    private PensionPlan pensionplan;

    public Employee(Long employeeId, String fName, String lName, LocalDate employementDate,
            Double yearlySalary, String planRef, LocalDate enrollmentDate, Double monthlyContribution) {
        this.employeeId = employeeId;
        this.fName = fName;
        this.lName = lName;
        this.employementDate = employementDate;
        this.yearlySalary = yearlySalary;
        this.pensionplan = (planRef == null) ? null : new PensionPlan(planRef, enrollmentDate, monthlyContribution);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getEmployementDate() {
        return employementDate;
    }

    public void setEmployementDate(LocalDate employementDate) {
        this.employementDate = employementDate;
    }

    public Double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(Double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public PensionPlan getPensionplan() {
        return pensionplan;
    }

    public String toJSONString() {
        String planReference = pensionplan != null ? pensionplan.getPlanRefernceNumber() : "null";
        String enrollmentDate = pensionplan != null && pensionplan.getEnrollmentDate() != null
                ? pensionplan.getEnrollmentDate().toString()
                : "null";
        String monthlyContribution = pensionplan != null ? String.format("%,.2f", pensionplan.getMonthlyContribution())
                : "null";
                
        return String.format(
                "\t{ \"employeeId\": %d, \"fName\": \"%s\", \"lName\": \"%s\", \"employmentDate\": \"%s\", \"yearlySalary\": %,.2f, \"planReference\": %s, \"enrollmentDate\": %s, \"monthlyContribution\": %s }",
                employeeId, fName, lName, employementDate != null ? employementDate.toString() : "null", yearlySalary,
                planReference, enrollmentDate,
                monthlyContribution);
    }

}
