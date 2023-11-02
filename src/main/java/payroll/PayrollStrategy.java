package payroll;

public interface PayrollStrategy {
    double calculateSalary(int hoursWorked, double hourlyRate);
}
