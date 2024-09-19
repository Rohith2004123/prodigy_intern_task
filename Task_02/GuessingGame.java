import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {
        // Create a random number generator and scanner for input
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess what it is?");

        // Loop until the user guesses the correct number
        while (guess != targetNumber) {
            System.out.print("Enter your guess: ");
            
            try {
                guess = scanner.nextInt();
                attempts++;

                // Provide feedback to the user
                if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    System.out.println("It took you " + attempts + " attempts.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Close the scanner
        scanner.close();
    }
}
