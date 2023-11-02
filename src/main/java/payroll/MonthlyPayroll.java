package payroll;

public class MonthlyPayroll implements PayrollStrategy {
    @Override
    public double calculateSalary(int hoursWorked, double hourlyRate) {
        return 40 * hourlyRate; // Assuming a fixed 40-hour workweek
    }
}