import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			// Display menu
			System.out.println("Calculator Menu:");
			System.out.println("1. Addition");
			System.out.println("2. Subtraction");
			System.out.println("3. Multiplication");
			System.out.println("4. Division");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			// Validate user input for menu choice
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next(); // Consume the invalid input
			}
			choice = scanner.nextInt();

			// Perform corresponding operation
			switch (choice) {
				case 1:
					Addition();
					break;
				case 2:
					Subtraction();
					break;
				case 3:
					Multiplication();
					break;
				case 4:
					Division();
					break;
				case 5:
					System.out.println("Exiting calculator !");
					break;
				default:
					System.out.println("Invalid choice. Please enter a choice between 1 and 5.");
			}
		} while (choice != 5);

		scanner.close();
	}

	// Function to perform addition
	private static void Addition() {
		double num1 = getNumberInput("Enter the first number: ");
		double num2 = getNumberInput("Enter the second number: ");
		double result = num1 + num2;
		System.out.println("Result: " + result);
	}

	// Function to perform subtraction
	private static void Subtraction() {
		double num1 = getNumberInput("Enter the first number: ");
		double num2 = getNumberInput("Enter the second number: ");
		double result = num1 - num2;
		System.out.println("Result: " + result);
	}

	// Function to perform multiplication
	private static void Multiplication() {
		double num1 = getNumberInput("Enter the first number: ");
		double num2 = getNumberInput("Enter the second number: ");
		double result = num1 * num2;
		System.out.println("Result: " + result);
	}

	// Function to perform division
	private static void Division() {
		double num1 = getNumberInput("Enter the first number: ");
		double num2;
		do {
			num2 = getNumberInput("Enter the second number (not zero): ");
			if (num2 == 0) {
				System.out.println("Error: Division by zero is not allowed. Please enter a non-zero number.");
			}
		} while (num2 == 0);
		double result = num1 / num2;
		System.out.println("Result: " + result);
	}

	// Function to get a valid number input from the user
	private static double getNumberInput(String message) {
		Scanner scanner = new Scanner(System.in);
		double number = 0;
		boolean validInput = false;

		while (!validInput) {
			System.out.print(message);
			if (scanner.hasNextDouble()) {
				number = scanner.nextDouble();
				validInput = true;
			} else {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.next(); // Consume the invalid input
			}
		}

		return number;
	}
}
