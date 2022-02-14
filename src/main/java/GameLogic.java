import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class GameLogic extends GameLogicFlow {
    public abstract String getCurrentPlayer();

    public abstract String getWinner();

    public abstract void setPlayer1(String player1);

    public abstract void setPlayer2(String player2);

    public abstract void setCurrentPlayer(String currentPlayer);

    public abstract void setWinner(String currentPlayer);


    public static void game1(TicTacToe game2,
                             Players player1,
                             Players player2,
                             Players currentPlayer,
                             boolean ai) {

        System.out.println("\n" + "==============================");
        System.out.println("Example of a TIC TAC TOE BOARD");
        System.out.println("==============================");

        Arrays.stream(game2.getGameBoard()).forEach(System.out::print);
        currentPlayer=player1;

        GamePiece[] toArray = new GamePiece[9];

        for (int i = 0; i < game2.toArray(game2.getGameBoard()).size(); i++) {
            toArray[i] = game2.toArray(game2.getGameBoard()).get(i);
        }
        boolean checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());

        System.out.println(" ");
        System.out.println("==============================checkGame==============================");
        System.out.println(checkGame1);

        while (!checkGame1) {
            boolean validInput = false;
            int currentPlayerInput;
            String strInput;
            Scanner input = new Scanner(System.in);
            while (!validInput) {
                System.out.println("  ");
                System.out.println("Please enter a number 0-8");
                strInput = input.nextLine();

                try {
                    currentPlayerInput = Integer.parseInt(strInput);
                    validInput = true;
                    if (currentPlayer == player1) {
                        game2.changeValue(game2.getGameBoard(), currentPlayerInput, currentPlayer);

                        Arrays.stream(game2.getGameBoard()).forEach(System.out::print);

                        checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner=currentPlayer.player;
                            break;
                        }
                        if (currentPlayer == player1) {
                            currentPlayer = player2;
                        } else if (currentPlayer == player2) {
                            currentPlayer = player1;
                        }
                    }
                    //check to see if ai ==true and if current player ==ai
                    if (ai  && currentPlayer == player2) {
                        Random random = new Random();
                        int randomInt = random.nextInt(9);
                        game2.changeValue(game2.getGameBoard(), randomInt, currentPlayer);
                        System.out.println("\n"+"==============================Line Break==============================");

                        Arrays.stream(game2.getGameBoard()).forEach(System.out::print);
                        checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            break;
                        }
                        if (currentPlayer == player1) {
                            currentPlayer = player2;
                        } else if (currentPlayer == player2) {
                            currentPlayer = player1;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("That is not a Number");
                }

            }
        }
        System.out.println("  ");
        System.out.println("Game Over");
    }

    public static void game2(Connectfour game3,
                                Players player1,
                                Players player2,
                                Players currentPlayer,
                                boolean ai) {
        System.out.println("==============================");
        System.out.println("Example of a Connect 4   BOARD");
        System.out.println("==============================");
        Arrays.stream(game3.getGameBoard()).forEach(System.out::print);
        currentPlayer=player1;
        GamePiece[] toArray1 = new GamePiece[42];

        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray1[i] = game3.toArray(game3.getGameBoard()).get(i);
        }
        boolean checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());
        //just a working version of what the input loop will be
        // will try to full implement by next sub
        while (!checkGame1) {
            boolean validInput = false;
            int currentPlayerInput;
            String strInput;
            Scanner input = new Scanner(System.in);

            while (!validInput) {
                System.out.println("  ");
                System.out.println("Please enter a number 0-41");
                strInput = input.nextLine();

                try {
                    currentPlayerInput = Integer.parseInt(strInput);
                    validInput = true;

                    if (currentPlayer == player1) {
                        game3.changeValue(game3.getGameBoard(), currentPlayerInput, currentPlayer);
                        System.out.println("\n"+"==============================Line Break==============================");
                        Arrays.stream(game3.getGameBoard()).forEach(System.out::print);
                        checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());

                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner=currentPlayer.player;
                        }
                        if (currentPlayer == player1) {
                            currentPlayer = player2;
                        } else if (currentPlayer == player2) {
                            currentPlayer = player1;
                        }
                    }
                    //check to see if ai ==true and if current player ==ai
                    if (ai  && currentPlayer == player2) {
                        Random random = new Random();
                        int randomInt = random.nextInt(42);
                        game3.changeValue(game3.getGameBoard(), 1, currentPlayer);

                        System.out.println("\n"+"==============================Connect 4==============================");

                        Arrays.stream(game3.getGameBoard()).forEach(System.out::print);
                        checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            break;
                        }
                        if (currentPlayer == player1) {
                            currentPlayer = player2;
                        } else if (currentPlayer == player2) {
                            currentPlayer = player1;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("That is not a Number");
                }
            }
        }
        System.out.println("  ");
        System.out.println("Game Over");
    }
}
