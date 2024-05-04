import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSORS = 3;

    private static String getChoiceName(int choice) {
        switch (choice) {
            case ROCK:
                return "Rock";
            case PAPER:
                return "Paper";
            case SCISSORS:
                return "Scissors";
            default:
                return "Invalid Choice";
        }
    }

    private static String determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        } else if ((userChoice == ROCK && computerChoice == SCISSORS) ||
                   (userChoice == PAPER && computerChoice == ROCK) ||
                   (userChoice == SCISSORS && computerChoice == PAPER)) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock, Paper, Scissors!");

        while (true) {
            System.out.print("\nEnter your choice (1 for Rock, 2 for Paper, 3 for Scissors, or 0 to quit): ");
            int userChoice = scanner.nextInt();

            if (userChoice == 0) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }

            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            int computerChoice = random.nextInt(3) + 1;
            System.out.println("You chose: " + getChoiceName(userChoice));
            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            String result = determineWinner(userChoice, computerChoice);
            System.out.println(result);
        }

        scanner.close();
    }
}
