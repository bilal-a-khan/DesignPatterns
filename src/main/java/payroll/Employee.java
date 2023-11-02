package payroll;

public class Employee {
    private PayrollStrategy strategy;
    private String name;
    private int hoursWorked;
    private double hourlyRate;

    public Employee(PayrollStrategy strategy, String name, int hoursWorked, double hourlyRate) {
        this.strategy = strategy;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculatePayroll() {
        return strategy.calculateSalary(hoursWorked, hourlyRate);
    }

    public String getName() {
        return name;
    }
}

