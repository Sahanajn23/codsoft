import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Game!");
        int lowerBound = 1;
        int upperBound = 100;
        int attemptsLimit = 10;
        int score = 0;

        do {
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nI've generated a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

            int attempts = 0;
            int userGuess;

            while (true) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += attempts;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == attemptsLimit) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + numberToGuess);
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }
}
