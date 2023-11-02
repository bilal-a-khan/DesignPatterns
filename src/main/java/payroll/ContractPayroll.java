package payroll;

public class ContractPayroll implements PayrollStrategy {
    @Override
    public double calculateSalary(int hoursWorked, double hourlyRate) {
        return 4 * hourlyRate * hoursWorked; // Assuming a fixed rate for a contract
    }
}
