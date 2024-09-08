package com.mortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(int principleAmount, float annualInterestRate, byte period) {
        double mortgage = Main.calculateMortgage(principleAmount, annualInterestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMORTGAGE\n--------\nMonthly payments: " + mortgageFormatted);
    }
    public static void printPaymentSchedule(byte period, int principleAmount, float annualInterestRate) {
        System.out.println("\nPAYMENT SCHEDULE\n----------------\n");
        for (short month = 1; month <= period * Main.monthsPerYear; month++) {
            double balance = Main.calculateBalance(principleAmount, annualInterestRate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
