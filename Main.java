import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private String employeeId;
    private String position;

    public Employee(String name, String employeeId, String position) {
        this.name = name;
        this.employeeId = employeeId;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getPosition() {
        return position;
    }

    public double calculateSalary() {
        return 0;
    }

    @Override
    public String toString() {
        return name + " id = " + employeeId + " должность " + position;
    }
}

class Worker extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Worker(String name, String employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId, "Рабочий");
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class Manager extends Employee {
    private double fixedSalary;
    private double bonus;

    public Manager(String name, String employeeId, double fixedSalary, double bonus) {
        super(name, employeeId, "Менеджер");
        this.fixedSalary = fixedSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary + bonus;
    }
}

class Company {
    private List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displaySalaries() {
        System.out.println("Зарплаты = ");
        for (Employee employee : employees) {
            System.out.println(employee + " Зарплата = " + employee.calculateSalary());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Worker worker1 = new Worker("Дастан", "1", 15.0, 160);
        Worker worker2 = new Worker("Ерко", "2", 20.0, 150);
        Manager manager1 = new Manager("Бекс", "1", 3000.0, 500.0);
        Manager manager2 = new Manager("Манат", "2", 3500.0, 700.0);

        company.addEmployee(worker1);
        company.addEmployee(worker2);
        company.addEmployee(manager1);
        company.addEmployee(manager2);

        company.displaySalaries();
    }
}
