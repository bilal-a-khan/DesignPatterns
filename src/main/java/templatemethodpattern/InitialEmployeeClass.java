package templatemethodpattern;

import java.security.InvalidParameterException;
import java.time.LocalDate;

public class InitialEmployeeClass {
    String name;
    Address address;
    LocalDate birthday;
    String employeeType;
    double payRate;
    TimeCard timeCard;
    double yearToDateEarnings = 0;

    public double computeNetPay() {
        //determine the base pay for the period
        double periodPay = 0;
        switch(employeeType) {
            case "hourly" -> {
                double hoursWorked = timeCard.getHoursWorked();
                double overtimePay = 0;
                double basePay = hoursWorked*payRate;
                if(hoursWorked > 40) {
                    overtimePay = (hoursWorked - 40)*1.5*payRate;
                    periodPay = basePay + overtimePay;
                }
            }case "weekly" -> {
                periodPay = payRate;
            }
            case "monthly" -> {
                periodPay = payRate;
            }
            default -> {
                throw new InvalidParameterException(employeeType + " is not a valid employee type");
            }
        }

        //annualize the pay in order to calculate the federal taxes
        double annualPay = 0;
        int payFrequency =0;
        switch(employeeType) {
         case "hourly" -> {
             payFrequency = 52;
         }
         case "weekly" -> {
             payFrequency = 52;
         }
            case "monthly" -> {
                payFrequency = 12;
            }
        }

        annualPay = periodPay*payFrequency;

        //calculate the federal taxes
        double federalTaxes = 0;
        if (annualPay < 25000 ) {
            federalTaxes = .14*annualPay / payFrequency;
        }
        else if(annualPay >= 25000 && annualPay < 50000) {
            federalTaxes = (3500 + (annualPay - 25000)*.24)/payFrequency;
        }
        else if(annualPay >= 50000) {
            federalTaxes = (9500 + (annualPay - 50000)*.36)/payFrequency;
        }

        //calculate the state taxes
        //this should be a really long switch statement with 51 cases! (50 states plus Washington, DC
        double stateTaxes = 0;
        switch (address.getState()) {
            case "AL" -> {
                stateTaxes = .02*periodPay;
            }

            case "CA" -> {
                stateTaxes = .10*periodPay;
            }

            case "FL" -> {
                stateTaxes = .03*periodPay;
            }
            default -> {
                stateTaxes = .05*periodPay;
            }
        }

        //calculate Social Security Taxes
        //Social Security Taxes are only collected on the first 168,000 of income
        double socialSecurityTaxes = 0;
        if(yearToDateEarnings < 168000) {
            socialSecurityTaxes = .15*periodPay;
        }

        yearToDateEarnings += periodPay;
        double netPay = periodPay - federalTaxes - stateTaxes - socialSecurityTaxes;

        //transfer the funds
        //bunch of code here to transfer the funds.  Probably highly secure and dealing with HTTP Requests
        return netPay;
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

    public void setTimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }
}
