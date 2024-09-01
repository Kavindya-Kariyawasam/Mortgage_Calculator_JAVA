import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principleAmount = 0;
        float annualInterestRate = 0;
        byte period = 0;

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
            annualInterestRate = scanner.nextFloat();
            if (annualInterestRate<=30 && annualInterestRate>=1)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {
            System.out.print("Period(Years): ");
            period = scanner.nextByte();
            if (period>=1 && period<=30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = calculateMortgage(principleAmount, annualInterestRate, period);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateMortgage(int principleAmount, float annualInterestRate, byte years) {
        final byte monthsPerYear = 12;

        int numberOfPayments = years * monthsPerYear;
        float monthlyInterestRatePercentage = annualInterestRate/monthsPerYear/100;

        return  (principleAmount * monthlyInterestRatePercentage * Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments))/(Math.pow((1 + monthlyInterestRatePercentage), numberOfPayments)-1);
    }
}