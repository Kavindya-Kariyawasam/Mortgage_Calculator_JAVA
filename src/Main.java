import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte monthsPerYear = 12;

    public static void main(String[] args) {
        int principleAmount = (int) readNumber("Enter principle amount($1K - $1M): ", 1_000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual interest rate: ", 1, 30);
        byte period = (byte) readNumber("Period(Years): ", 1, 30);

        double mortgage = calculateMortgage(principleAmount, annualInterestRate, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("\nMORTGAGE\n--------\nMonthly payments: " + mortgageFormatted);

        System.out.println("\nPAYMENT SCHEDULE\n----------------\n");
        for (short month = 1; month <= period * monthsPerYear; month++) {
            double balance = calculateBalance(principleAmount, annualInterestRate, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value>=min && value<=max)
                break;
            System.out.println("Enter a value between " + min + " and " +max);
        }
        return value;
    }

    public static double calculateBalance(double principleAmount, float annualInterestRate, byte years, short numberOfPaymentsMade) {
        int numberOfPayments = years * monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/100;

        double balance = principleAmount *
                (Math.pow(1+monthlyInterestRatePercentage, numberOfPayments)-Math.pow(1+monthlyInterestRatePercentage, numberOfPaymentsMade))/
                (Math.pow(1+monthlyInterestRatePercentage, numberOfPayments)-1);
        return balance;
    }

    public static double calculateMortgage(double principleAmount, float annualInterestRate, byte years) {
        int numberOfPayments = years * monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/100;

        double mortgage =  (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments))/
                (Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)-1);
        return mortgage;
    }
}