package payroll;

public class HourlyPayroll implements PayrollStrategy {
    @Override
    public double calculateSalary(int hoursWorked, double hourlyRate) {
        return hoursWorked * hourlyRate;
    }
}