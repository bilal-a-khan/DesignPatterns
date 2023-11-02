package templatemethodpattern;

import java.time.LocalDate;

public  abstract class EmployeeWithHookOperation {
    String name;
    Address address;
    LocalDate birthday;
    String employeeType;
    double payRate;

    double yearToDateEarnings = 0;

    public double computeNetPay() {
        double periodPay = 0;
        double annualPay = 0;
        int payFrequency = 0;
        double netPay = 0;

        periodPay = getPeriodPay(periodPay);
        payFrequency = getPayFrequency();
        annualPay = periodPay*payFrequency;

        double federalTaxes = calculateFederalTaxes(annualPay, payFrequency);
        double stateTaxes = calculateStateTaxes(periodPay);
        double socialSecurityTaxes = calculateSocialSecurityTaxes(periodPay);
        double unionDues = calculateUnionDues(periodPay);

        netPay = periodPay - federalTaxes - stateTaxes - socialSecurityTaxes - unionDues;

        transferFunds(netPay);
        yearToDateEarnings += periodPay;

        return netPay;
    }

    private double calculateUnionDues(double periodPay) {
        return 0;
    }

    protected double calculateSocialSecurityTaxes(double periodPay) {
        double socialSecurityTaxes = 0;
        if(yearToDateEarnings < 168000) {
            socialSecurityTaxes = .15* periodPay;
        }
        return socialSecurityTaxes;
    }

    protected double calculateStateTaxes(double periodPay) {
        double stateTaxes = 0;
        switch (address.getState()) {
            case "AL" -> {
                stateTaxes = .02* periodPay;
            }

            case "CA" -> {
                stateTaxes = .10* periodPay;
            }

            case "FL" -> {
                stateTaxes = .03* periodPay;
            }
            default -> {
                stateTaxes = .05* periodPay;
            }
        }
        return stateTaxes;
    }

    protected double calculateFederalTaxes(double annualPay, int payFrequency) {
        double federalTaxes = 0;
        if (annualPay < 25000 ) {
            federalTaxes = .14* annualPay / payFrequency;
        }
        else if(annualPay >= 25000 && annualPay < 50000) {
            federalTaxes = (3500 + (annualPay - 25000)*.24)/ payFrequency;
        }
        else if(annualPay >= 50000) {
            federalTaxes = (9500 + (annualPay - 50000)*.36)/ payFrequency;
        }
        return federalTaxes;
    }

    protected abstract int getPayFrequency();

    protected abstract double getPeriodPay(double periodPay);

    protected void transferFunds(double netPay) {
        //code here that does the transferring
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }


}
