import java.util.*;

public class aparicio_assignment2 {

    public static void main(String[] args) {

        monthlyPayment();
    }

    public static void monthlyPayment() // Method to obtain monthly payment.
    {
        Scanner sc = new Scanner(System.in); // Reads input from user

        System.out.println("How much is the loan amount? ");
        double loanAmount = sc.nextDouble();

        System.out.println("What is the annual interest rate? ");
        double interestRate = sc.nextDouble();

        System.out.println(); // Sets cursor to new line so it could read correct user input.
        System.out.println("Enter the number of years: ");
        int years = sc.nextInt();

        double loanPeriod = (years * 12);

        // Compute periodic interest rate
        double periodicInterestRate = interestRate / 12;

        // Compute monthly payment
        double monthlyPayment = (periodicInterestRate * loanAmount) / (1 - (Math.pow(1 + periodicInterestRate,
                -loanPeriod)));

        // Compute Total Cost
        double totalCost = (monthlyPayment * years * 12);

        // Compute Ratio paid over principal
        double ratioOverPrincipal = (((monthlyPayment * loanPeriod) - loanAmount) * 100) / loanAmount;


        System.out.printf("Loan Amount: $%.2f", loanAmount);
        System.out.println();
        System.out.printf("Interest Rate: %.2f%%", interestRate * 100); // %% prints out percent symbol.
        System.out.println();
        System.out.printf("Monthly Payment: $%.2f", monthlyPayment);
        System.out.println();
        System.out.printf("Total Cost: $%.2f", totalCost);
        System.out.println();
        System.out.printf("Ratio paid over principal: %.2f%%", ratioOverPrincipal);

        // Calculate Balance
        double balance = loanAmount;
        for (int period = 1; period <= loanPeriod; period++)
        {
            double monthlyInterest = balance * periodicInterestRate;
            double principal = monthlyPayment - monthlyInterest;

            balance -= principal;

            System.out.printf("Monthly Payment: $%.2f", monthlyPayment);
            System.out.printf(" Principal Amount: $%.2f", principal);
            System.out.printf(" Interest Amount: $%.2f", monthlyInterest);
            System.out.printf(" Amount Left: $%.2f", balance);
            System.out.println();

            if (period % 12 == 0){
                int year = period / 12;
                System.out.println("*** End of Year " + year +" ***");
            }
        }

    }
}