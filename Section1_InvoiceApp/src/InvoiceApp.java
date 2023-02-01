import java.util.Scanner;
/****************************************************************

Description: First assignment for modifying the Invoice App code. This code uses the programming 
lanquage java to help with the users invoice. 
Programmer’s name: Scout Ashburn
Date Written: January 27, 2023
GitHub repository URL: https://github.com/scashb01/JavaProject
Token: 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
 *****************************************************************/
public class InvoiceApp {
	public static void main(String[] args) {
		// initialize variables for use in calculating averages
		int invoiceCount = 0;
		int lineItems = 0;
		double invoiceTotal = 0.0;
		double discountTotal = 0.0;
		double discountPercent = 0.0;
		double subtotal = 0.0;
		double discountAmount = subtotal * discountPercent;
		double total = 0.0;
		String choice = "y";
		String message = "?";

		// welcome the user to the program
		System.out.println("===========================================");
		System.out.println("Welcome to the Invoice Total Calculator v5");
		System.out.println("===========================================");
		System.out.println();  // print a blank line

		// create a Scanner object named sc
		Scanner sc = new Scanner(System.in);

		// perform invoice calculations until choice is "n" or "N" 
		while (!choice.equalsIgnoreCase("n")) {

			// get the invoice Line Items from the user

			System.out.print("Enter number of invoice items:   ");
			lineItems = sc.nextInt();
			System.out.println();
			System.out.println("===========================================");
			System.out.println();

			for(int i = 0; i < lineItems; i++) {

				System.out.print("Enter line item amount:   ");
				subtotal += sc.nextDouble();
			}
			System.out.println();
			System.out.println("===========================================");
			System.out.println();
			// calculate the discount amount and total


			if (subtotal >= 500) {
				discountPercent = 0.25;
			} else if (subtotal >= 200) {
				discountPercent = 0.2;
			} else if (subtotal >= 100) {
				discountPercent = 0.1;
			} else {
				discountPercent = 0.0;
			}

			discountAmount = subtotal * discountPercent;
			total = subtotal - discountAmount;

			// accumulate the invoice count and invoice total
			invoiceTotal = invoiceTotal + total;
			discountTotal = discountTotal + discountAmount;
			invoiceCount = invoiceCount + 1;  
			// display the discount amount and total
			System.out.printf("%20s: %,10.2f\n", "Subtotal", subtotal);
			System.out.printf("%20s: %,10.2f\n", "Discount Percent", discountPercent);
			System.out.printf("%20s: %,10.2f\n", "Discount Amount", discountAmount );
			System.out.printf("%20s: %,10.2f\n", "Invoice Total", total);


			System.out.println();
			System.out.println("===========================================");
			System.out.println();
			choice = sc.nextLine();
			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.nextLine();
			System.out.println();
		}
		System.out.println();
		System.out.println("===========================================");
		System.out.println();
		System.out.printf("%20s: %,10.2f\n", "Number of invoices", (invoiceCount * 1.0));
		System.out.printf("%20s: %,10.2f\n", "Average invoice", (invoiceTotal / invoiceCount));
		System.out.printf("%20s: %,10.2f\n", "Average discount", (discountTotal / invoiceCount));
		// calculate and display invoice count, average invoice, and average 
		/*	message = "Number of invoices: " + invoiceCount + "\n"
				+ "Average invoice:    " + invoiceTotal / invoiceCount + "\n"
				+ "Average discount:   " + discountTotal / invoiceCount + "\n";
		System.out.println(message);*/
		sc.close();//end of main
	}
}