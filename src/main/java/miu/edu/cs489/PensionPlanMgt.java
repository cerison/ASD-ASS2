package miu.edu.cs489;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class PensionPlanMgt {
    public static void main(String[] args) {
        var employees = List.of(
                new Employee(1L, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, "EX1089",
                        LocalDate.of(2023, 1, 17), 100.00),
                new Employee(2L, "Bernard", "Shaw", LocalDate.of(2018, 10, 3), 197750.50, null, null, null),
                new Employee(3L, "Carly", "Agar", LocalDate.of(2014, 5, 16), 842000.75, "SM2307",
                        LocalDate.of(2019, 11, 4), 1555.50),
                new Employee(4L, "Wesley", "Schneider", LocalDate.of(2018, 11, 2), 74500.00, null, null, null));

        printEmployees(employees);

        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusMonths(1);
        LocalDate startOfNextMonth = nextMonth.withDayOfMonth(1);
        LocalDate endOfNextMonth = nextMonth.withDayOfMonth(nextMonth.lengthOfMonth());

        var eligibleList = employees.stream()
                .filter(employee -> employee.getPensionplan() == null)
                .filter(employee -> {
                    LocalDate employmentDate = employee.getEmployementDate();
                    LocalDate eligibilityDate = employmentDate.plusYears(5);
                    return !eligibilityDate.isBefore(startOfNextMonth) && !eligibilityDate.isAfter(endOfNextMonth);
                })

                .sorted(Comparator.comparing(Employee::getlName)
                        .thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()))
                .toList();

        printEmployees(eligibleList);
    }

    private static void printEmployees(List<Employee> employees) {
        if (!employees.isEmpty()) {
            System.out.println("Printed in JSON Format");
            System.out.println("[");
            int numEmployees = employees.size();
            for (int i = 0; i < numEmployees; i++) {
                String employee = employees.get(i).toJSONString();
                System.out.print(employee);
                if (i != (numEmployees - 1)) {
                    System.out.println(",");
                }
            }
            System.out.println("\n]");
        } else {
            System.out.println("[]");
        }
    }
}