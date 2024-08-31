import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte monthsPerYear = 12;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter principle amount: ");
        int principleAmount = scanner.nextInt();

        System.out.print("Annual interest rate: ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/100;

        System.out.print("Period(Years): ");
        byte period = scanner.nextByte();

        int numberOfPayments = period * monthsPerYear;

        double calculatedTotal = (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments))/(Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)-1);

        String Mortgage = NumberFormat.getCurrencyInstance().format(calculatedTotal);
        System.out.println("Mortgage: " + Mortgage);
    }
}