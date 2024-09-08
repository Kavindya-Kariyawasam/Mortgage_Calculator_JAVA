package com.mortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculation calculator;

    public MortgageReport(MortgageCalculation calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE\n----------------\n");
        for (short month = 1; month <= calculator.getYears() * Main.monthsPerYear; month++) {
            double balance = calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMORTGAGE\n--------\nMonthly payments: " + mortgageFormatted);
    }
}
