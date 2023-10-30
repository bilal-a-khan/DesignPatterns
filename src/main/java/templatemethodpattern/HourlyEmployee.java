package templatemethodpattern;

public class HourlyEmployee extends SecondRefactoringEmployeeAsASuperClass {
    TimeCard timeCard;
    static int HOURLY_PAY_FREQUENCY = 52;

    public HourlyEmployee() {
        super(HOURLY_PAY_FREQUENCY);
    }

    @Override
    protected int getPayFrequency() {
        return payFrequency;
    }

    @Override
    protected double getPeriodPay(double periodPay) {
        double hoursWorked = timeCard.getHoursWorked();
        double overtimePay = 0;
        double basePay = hoursWorked*payRate;
        if(hoursWorked > 40) {
            overtimePay = (hoursWorked - 40)*1.5*payRate;
            periodPay = basePay + overtimePay;
        }
        return periodPay;
    }

    public void setTimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }

}
