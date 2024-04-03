package miu.edu.cs489;

import java.time.LocalDate;

public class PensionPlan {
    private String planRefernceNumber;
    private LocalDate enrollmentDate;
    private Double monthlyContribution;

    public PensionPlan(String planRefernceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planRefernceNumber = planRefernceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanRefernceNumber() {
        return planRefernceNumber;
    }

    public void setPlanRefernceNumber(String planRefernceNumber) {
        this.planRefernceNumber = planRefernceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(Double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }
}
