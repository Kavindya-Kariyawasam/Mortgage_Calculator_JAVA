package com.mortgageCalculator;

public class MortgageCalculation {
    private int principleAmount;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculation(int principleAmount, float annualInterestRate, byte years) {
        this.principleAmount = principleAmount;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        int numberOfPayments = years * Main.monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate / Main.monthsPerYear / Main.PERCENT;

        double balance = principleAmount *
                (Math.pow(1 + monthlyInterestRatePercentage, numberOfPayments) - Math.pow(1 + monthlyInterestRatePercentage, numberOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterestRatePercentage, numberOfPayments) - 1);
        return balance;
    }

    public double calculateMortgage() {
        int numberOfPayments = years * Main.monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate / Main.monthsPerYear / Main.PERCENT;

        double mortgage = (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)) /
                (Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments) - 1);
        return mortgage;
    }

    public byte getYears() {
        return years;
    }
}
