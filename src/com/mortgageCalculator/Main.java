package com.mortgageCalculator;

//import com.mortgageCalculator.Console;

public class Main {
    final static byte monthsPerYear = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principleAmount = (int) Console.readNumber("Enter principle amount($1K - $1M): ", 1_000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual interest rate: ", 1, 30);
        byte period = (byte) Console.readNumber("Period(Years): ", 1, 30);

        MortgageReport.printMortgage(principleAmount, annualInterestRate, period);
        MortgageReport.printPaymentSchedule(period, principleAmount, annualInterestRate);
    }

    public static double calculateBalance(double principleAmount, float annualInterestRate, byte years, short numberOfPaymentsMade) {
        int numberOfPayments = years * monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/PERCENT;

        double balance = principleAmount *
                (Math.pow(1+monthlyInterestRatePercentage, numberOfPayments)-Math.pow(1+monthlyInterestRatePercentage, numberOfPaymentsMade))/
                (Math.pow(1+monthlyInterestRatePercentage, numberOfPayments)-1);
        return balance;
    }

    public static double calculateMortgage(double principleAmount, float annualInterestRate, byte years) {
        int numberOfPayments = years * monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/PERCENT;

        double mortgage =  (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments))/
                (Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)-1);
        return mortgage;
    }
}