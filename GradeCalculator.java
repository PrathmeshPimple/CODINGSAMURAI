import java.util.Scanner;

public class GradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Constants for grading scale
		final double A_GRADE = 90;
		final double B_GRADE = 80;
		final double C_GRADE = 70;
		final double D_GRADE = 60;

		// Variables to store grades and weights
		double assignments, quizzes, midtermExam, finalExam;
		double assignmentsWeight, quizzesWeight, midtermExamWeight, finalExamWeight;

		// Get grades and weights from user
		System.out.print("Enter your assignment Marks: ");
		assignments = getValidGrade(scanner);
		System.out.print("Enter the weight for assignments (in percentage): ");
		assignmentsWeight = getValidWeight(scanner);

		System.out.print("Enter your quiz Marks: ");
		quizzes = getValidGrade(scanner);
		System.out.print("Enter the weight for quizzes (in percentage): ");
		quizzesWeight = getValidWeight(scanner);

		System.out.print("Enter your midterm exam Marks: ");
		midtermExam = getValidGrade(scanner);
		System.out.print("Enter the weight for midterm exam (in percentage): ");
		midtermExamWeight = getValidWeight(scanner);

		System.out.print("Enter your final exam Marks: ");
		finalExam = getValidGrade(scanner);
		System.out.print("Enter the weight for final exam (in percentage): ");
		finalExamWeight = getValidWeight(scanner);

		// Calculate weighted average
		double weightedAverage = (assignments * assignmentsWeight / 100)
				+ (quizzes * quizzesWeight / 100)
				+ (midtermExam * midtermExamWeight / 100)
				+ (finalExam * finalExamWeight / 100);

		// Determine letter grade
		char letterGrade;
		if (weightedAverage >= A_GRADE) {
			letterGrade = 'A';
		} else if (weightedAverage >= B_GRADE) {
			letterGrade = 'B';
		} else if (weightedAverage >= C_GRADE) {
			letterGrade = 'C';
		} else if (weightedAverage >= D_GRADE) {
			letterGrade = 'D';
		} else {
			letterGrade = 'F';
		}

		// Display final grade
		System.out.println("Your final grade is: " + weightedAverage);
		System.out.println("Your letter grade is: " + letterGrade);

		scanner.close();
	}

	// Helper function to get a valid grade from the user
	private static double getValidGrade(Scanner scanner) {
		double grade = -1;
		while (grade < 0 || grade > 100) {
			System.out.print("Enter a valid grade (0-100): ");
			if (scanner.hasNextDouble()) {
				grade = scanner.nextDouble();
				if (grade < 0 || grade > 100) {
					System.out.println("Invalid input. Grade must be between 0 and 100.");
				}
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next(); // Consume the invalid input
			}
		}
		return grade;
	}

	// Helper function to get a valid weight from the user
	private static double getValidWeight(Scanner scanner) {
		double weight = -1;
		while (weight < 0 || weight > 100) {
			System.out.print("Enter a valid weight (0-100): ");
			if (scanner.hasNextDouble()) {
				weight = scanner.nextDouble();
				if (weight < 0 || weight > 100) {
					System.out.println("Invalid input. Weight must be between 0 and 100.");
				}
			} else {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next(); // Consume the invalid input
			}
		}
		return weight;
	}
}
