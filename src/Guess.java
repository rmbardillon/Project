import java.util.Scanner;

public class Guess {
    public int randomNumber() {
        return (int) (Math.random() * 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Guess guess = new Guess();
        int randomNumber = guess.randomNumber();
        int tries = 3;
        int guessNumber = 0;

        System.out.println("Welcome to the Guessing Game! Answer is " + randomNumber);
        while(tries != 0) {
            System.out.println("Guess a number between 0 and 9");
            guessNumber = scanner.nextInt();
            if(guessNumber == randomNumber) {
                System.out.println("You guessed correctly!");
                break;
            } else {
                System.out.printf("You guessed incorrectly! You have %d tries left\n", tries - 1);
                tries--;
            }
        }
    }
}
