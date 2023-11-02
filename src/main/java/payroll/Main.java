package payroll;

public class Main {
    public static void main(String[] args) {
        Employee hourlyEmployee = new Employee(new HourlyPayroll(), "Steve", 50, 20);
        Employee monthlyEmployee = new Employee(new MonthlyPayroll(), "Mark", 40, 25);
        Employee contractEmployee = new Employee(new ContractPayroll(), "Bryan", 60, 15);

        System.out.println(hourlyEmployee.getName() + "'s salary: $" + hourlyEmployee.calculatePayroll());
        System.out.println(monthlyEmployee.getName() + "'s salary: $" + monthlyEmployee.calculatePayroll());
        System.out.println(contractEmployee.getName() + "'s salary: $" + contractEmployee.calculatePayroll());
    }
}
