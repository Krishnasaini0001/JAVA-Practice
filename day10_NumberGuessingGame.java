import java.util.Random;
import java.util.Scanner;
 
public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
 
        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 7;
        boolean guessedCorrectly = false;
 
        System.out.println("=== Number Guessing Game ===");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.\n");
 
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
 
            if (guess == secretNumber) {
                guessedCorrectly = true;
                System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
            } else if (guess < secretNumber) {
                System.out.println("Too low. Try higher.");
            } else {
                System.out.println("Too high. Try lower.");
            }
        }
 
        if (!guessedCorrectly) {
            System.out.println("\nOut of attempts! The number was: " + secretNumber);
        }
 
        scanner.close();
    }
}
 