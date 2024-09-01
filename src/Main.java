import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte monthsPerYear = 12;

        int principleAmount = 0, numberOfPayments = 0;
        float monthlyInterestRatePercentage = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter principle amount($1K - $1M): ");
            principleAmount = scanner.nextInt();
            if (principleAmount>1_000 && principleAmount<1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        while (true) {
            System.out.print("Annual interest rate: ");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate<=30 && annualInterestRate>=1) {
                monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/100;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period(Years): ");
            byte period = scanner.nextByte();
            if (period>=1 && period<=30) {
                numberOfPayments = period * monthsPerYear;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double calculatedTotal = (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments))/(Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)-1);

        String Mortgage = NumberFormat.getCurrencyInstance().format(calculatedTotal);
        System.out.println("Mortgage: " + Mortgage);
    }
}