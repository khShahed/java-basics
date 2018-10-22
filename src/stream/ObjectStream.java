package stream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectStream {
    public static void ObjectStreamTest(){

        List<Employee> employees = Arrays.asList(
                new Employee("Emp1", 12000, true),
                new Employee("Emp2", 19000, false),
                new Employee("Emp3", 100, true),
                new Employee("Emp4", 14000, true),
                new Employee("Emp5", 13000, false),
                new Employee("Emp6", 9000, true),
                new Employee("Emp7", 1000, true),
                new Employee("Emp8", 1900, true),
                new Employee()
        );

        System.out.println("*****Highest Earning 3 Employee with Details****");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("*****Highest Earning 3 Employee name****");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("*****Highest Earning 3 Active Employee with Details****");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .limit(3)
                .forEach(System.out::println);

        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .limit(3)
                .collect(Collectors.toList());
        // To Set
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .limit(3)
                .collect(Collectors.toSet());
        // To Map
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .limit(3)
                .collect(Collectors.toMap(e -> e.getName(), e -> e));

        System.out.println("Names -> " + employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .filter(Employee::isActive)
                .map(Employee::getName)
                .limit(3)
                .collect(Collectors.joining("\t"))
        );

        // Group By -- Can be used to group by dept or other prop
        Map<String, List<Employee>> groupByName =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getName));

        // Group By Count -- Can be used to count employee number in dept
        Map<String, Long> groupByNameCount =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        // Parallel Stream -- Only when more then 10,000-100,000 elements.
        employees.stream()
                .parallel()
                .collect(Collectors.groupingBy(Employee::getName));
    }
}

class Employee {
    private String name;
    private int salary;
    private boolean active;

    public Employee(){
        this("test", 1234, true);
    }

    public Employee(String name, int salary, boolean active) {
        this.name = name;
        this.salary = salary;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}