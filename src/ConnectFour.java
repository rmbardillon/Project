
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ConnectFour {
    static Random rand = new Random();
    static Scanner in = new Scanner(System.in);
    public static char[][] gameBoard = new char[6][7];
    static int turn = 1;
    static boolean win = false;
    static char player1 = ' ', player2 = ' ';
    static int player, computer;

    public static void main(String[] args) {
        while(true) {
            System.out.print("Start playing? \n1 - Start Game\n2 - Exit Program \nYour answer: ");
            int start = isInt(in);

            if (start == 1) {
                System.out.println("----------------------------");
                clearGameBoard();
                whoFirst();
            } else if(start == 2) {
                System.out.println("Thank you for using my program.");
                break;
            } else {
                System.out.println("--ERROR-- \nSorry. I can't find the value you entered. Please try again.");
                continue;
            }
        }
    }

    static void game(Boolean first) {
        int drop;
        if(first) {
            player = 1;

            computer = 2;
            player1 = playerOne();
            player2 = playerTwo(player1);
            System.out.println("User: "+ player1 + " Computer 2: "+ player2);
        } else {
            player = 2;
            computer = 1;
            player1 = playerOne();
            player2 = playerTwo(player1);
            System.out.println("Computer: "+ player1 + " User: "+ player2);
        }

        while (!win && turn != 42) {
            printGameBoard();
            System.out.println();

            if ((player == 1 && turn %2 != 0)|| (player == 2&& turn %2 == 0) ) {
                System.out.print("User " + whoseTurn(turn, player1, player2) + " Pick where to drop(1~7): ");
                drop = isInt(in) - 1;

                spotAvail(drop, whoseTurn(turn, player1, player2));
            }else {
                drop = computerTurn();
                spotAvail(drop, whoseTurn(turn, player1, player2));
                System.out.println("Computer choose " + (drop+1));
            }
            if (turn > 6) {
                if (winner(whoseTurn(turn, player1, player2))) {
                    if ((player == 1 && turn %2 != 0)|| (player == 2&& turn %2 == 0) ) {
                        System.out.print("Player ");
                    }else {
                        System.out.print("Computer ");
                    }

                    System.out.println(whoseTurn(turn, player1, player2) + " is the winner!");
                    printGameBoard();
                    break;
                }

            }
            turn++;
            if (turn == 42&& !winner(whoseTurn(turn, player1, player2))) {
                System.out.println("There is no possible valid position and no pattern have formed. Therefor the game is considered a draw ");
            }
        }
    }

    static void whoFirst() { //true == player, false == computer

        if (rand.nextBoolean()) {
            game(true);
        }else {
            game(false);
        }
    }

    static void printGameBoard() {
        System.out.println(" 1 2 3 4 5 6 7");
        for (int i = 0; i< 6; i++) {
            for (int j = 0; j< 7; j++) {
                System.out.print("|"+gameBoard[i][j]);
            }
            System.out.println("|");
        }
    }

    static void clearGameBoard() {

        for (int i = 0; i< 6; i++) {
            for (int j = 0; j< 7; j++) {
                gameBoard[i][j] = '\u0000';
            }


        }
    }

    static int computerTurn() {
        int cmptrn;
        do {
            cmptrn = rand.nextInt(7);
        } while(isSpotFull(cmptrn));
        return cmptrn;
    }

    static boolean isSpotFull(int drop) {
        return gameBoard[0][drop] != '\u0000';

    }

    static void spotAvail(int drop, char whoseTurn){
        for (int i = 5; i >= 0; i--) {
            if (gameBoard[i][drop] == '\u0000'){
                gameBoard[i][drop] = whoseTurn;

                break;
            }
        }
    }

    static char playerOne() {
        return rand.nextInt(2) == 0 ? 'R' : 'Y';
    }

    static char playerTwo(char p1) {
        char p2 = ' ';
        if (p1 == 'R') {
            p2 = 'Y';
        } else if (p1 == 'Y') {
            p2 = 'R';
        }
        return p2;
    }

    static char whoseTurn(int turn, char player1, char player2) {
        return turn % 2 == 0 ? player2 : player1;

    }

    public static int isInt(Scanner in) {
        int num;
        while (true) {
            try {
                num = in.nextInt();
                if (num < 1 || num > 7) {
                    System.out.print("Please Re-enter Integer from 1 to 7: ");
                    continue;
                } else if( isSpotFull(num-1)) {
                    System.out.print("Please pick another column because this column is full: ");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.print("Invalid Input. Please Re-enter Integer from 1 to 7: ");
            }
        }
        return num;
    }

    static Boolean winner(char whoseTurn) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length - 3; col++) {
                if (gameBoard[row][col] == whoseTurn &&
                        gameBoard[row][col + 1] == whoseTurn &&
                        gameBoard[row][col + 2] == whoseTurn &&
                        gameBoard[row][col + 3] == whoseTurn) {
                    return true;
                }

            }
        }
        for (int row = 0; row < gameBoard.length - 3; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                if (gameBoard[row][col] == whoseTurn &&
                        gameBoard[row + 1][col] == whoseTurn &&
                        gameBoard[row + 2][col] == whoseTurn &&
                        gameBoard[row + 3][col] == whoseTurn) {
                    return true;
                }
            }
        }
        for (int row = 3; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length - 3; col++) {
                if (gameBoard[row][col] ==

                        whoseTurn &&
                        gameBoard[row - 1][col + 1] == whoseTurn &&
                        gameBoard[row - 2][col + 2] == whoseTurn &&
                        gameBoard[row - 3][col + 3] == whoseTurn) {
                    return true;
                }
            }
        }
        for (int row = 0; row < gameBoard.length - 3; row++) {
            for (int col = 0; col < gameBoard[0].length - 3; col++) {
                if (gameBoard[row][col] == whoseTurn &&
                        gameBoard[row + 1][col + 1] == whoseTurn &&
                        gameBoard[row + 2][col + 2] == whoseTurn &&
                        gameBoard[row + 3][col + 3] ==

                                whoseTurn) {
                    return true;
                }
            }
        }
        return false;
    }
}
