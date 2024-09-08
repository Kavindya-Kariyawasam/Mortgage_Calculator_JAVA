package com.mortgageCalculator;

//import com.mortgageCalculator.Console;

public class Main {
    final static byte monthsPerYear = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principleAmount = (int) Console.readNumber("Enter principle amount($1K - $1M): ", 1_000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual interest rate: ", 1, 30);
        byte period = (byte) Console.readNumber("Period(Years): ", 1, 30);

        var calculator = new MortgageCalculation(principleAmount, annualInterestRate, period);
        var report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}