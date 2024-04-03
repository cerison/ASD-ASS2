package miu.edu.cs489;

import java.time.LocalDate;

public class Employee {
    private Long employeeId;
    private String fName;
    private String lName;
    private LocalDate employementDate;
    private Double yearlySalary;
    private PensionPlan pensionplan;

    public Employee(Long employeeId, String planRef, String fName, String lName, LocalDate employementDate,
            Double yearlySalary, LocalDate enrollmentDate, Double monthlyContribution) {
        this.employeeId = employeeId;
        this.fName = fName;
        this.lName = lName;
        this.employementDate = employementDate;
        this.yearlySalary = yearlySalary;
        this.pensionplan = new PensionPlan(planRef, enrollmentDate, monthlyContribution);
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

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", fName=" + fName + ", lName=" + lName + ", employementDate="
                + employementDate + ", yearlySalary=" + yearlySalary + "]";
    }

    public String toJSONString() {
        return String.format(
                "\t{ \"employeeId\":%d,\"planReference\":%d, \"fName\":\"%s\", \"fName\":\"%s\", \"employementDate\":%d, \"unitPrice\":%,.2f, \"yearlySalary\":%,.2f,\"enrollmentDate\":%d,\"monthlyContribution\":%d, }",
                employeeId, fName, lName, employementDate, yearlySalary, pensionplan.getEnrollmentDate(),
                pensionplan.getMonthlyContribution());
    }

}
