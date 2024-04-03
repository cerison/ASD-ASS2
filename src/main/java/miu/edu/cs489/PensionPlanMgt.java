package miu.edu.cs489;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PensionPlanMgt {
    public static void main(String[] args) {

        Employee[] employees = new Employee[] {
                new Employee(1L, "EX1089", "Daniel", "Agar", LocalDate.of(2017, 1, 17), 105945.50,
                        LocalDate.of(2017, 1, 17), 100.00),
                new Employee(2L, null, "Bernard", "Shaw", LocalDate.of(2019, 4, 3), 197750.00, null, null),
                new Employee(3L, "SM2307", "Carly ", "Agar", LocalDate.of(2014, 5, 16), 842000.75,
                        LocalDate.of(2019, 11, 4), 1555.50),
                new Employee(4L, null, "Wesley", "Schneider", LocalDate.of(2019, 5, 2), 74500.00, null, null),
        };

        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate startOfNextMonth = nextMonth.withDayOfMonth(1);
        LocalDate endOfNextMonth = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());

        var eligibleList = Arrays.stream(employees)
                .filter(employee -> employee.getPensionplan().getPlanRefernceNumber() == null)
                .filter(employee -> {
                    LocalDate employmentDate = employee.getEmployementDate();
                    LocalDate eligibilityDate = employmentDate.plusYears(5);
                    return !eligibilityDate.isAfter(endOfNextMonth) && eligibilityDate.isBefore(endOfNextMonth)
                            && !eligibilityDate.isBefore(startOfNextMonth);
                })
                .sorted(Comparator.comparing(Employee::getlName)
                        .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                .toList();

        printEmployees(eligibleList);

        var ineligibleList = Arrays.stream(employees)
                .filter(employee -> employee.getPensionplan().getPlanRefernceNumber() == null)
                .filter(employee -> {
                    LocalDate employmentDate = employee.getEmployementDate();
                    LocalDate eligibilityDate = employmentDate.plusYears(5);
                    return !eligibilityDate.isAfter(endOfNextMonth) && eligibilityDate.isBefore(endOfNextMonth)
                            && !eligibilityDate.isBefore(startOfNextMonth);
                })
                .sorted(Comparator.comparing(Employee::getlName)
                        .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                .toList();

        printEmployees(ineligibleList);
    }

    private static void printEmployees(List<Employee> employees) {
        System.err.println(employees.size());

        if (employees.size() > 0) {

            System.out.println("Printed in JSON Format");
            System.out.println("[");
            long numEmployees = employees.size();
            for (int i = 0; i < numEmployees; i++) {
                if ((i + 1) < numEmployees) {
                    System.out.printf("%s,\n", employees.get(i).toJSONString());
                } else {
                    System.out.println(employees.get(i).toJSONString());
                }
            }
            System.out.println("]");

        } else {
            System.out.println("[]");
        }
    }
}