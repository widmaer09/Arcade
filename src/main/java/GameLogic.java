import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public abstract class GameLogic extends GameLogicFlow {

    public static void game1(TicTacToe game2,
                             Players player1,
                             Players player2,
                             Players currentPlayer,
                             boolean ai) {

        System.out.println("\n" + "==============================");
        System.out.println("Example of a TIC TAC TOE BOARD");
        System.out.println("==============================");

        Arrays.stream(game2.getGameBoard()).forEach(System.out::print);
        currentPlayer = player1;

        GamePiece[] toArray = new GamePiece[9];


        for (int i = 0; i < game2.toArray(game2.getGameBoard()).size(); i++) {
            toArray[i] = game2.toArray(game2.getGameBoard()).get(i);
        }
        boolean checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());

        while (!checkGame1) {
            boolean validInput = false;
            int currentPlayerInput;
            String strInput;
            Scanner input = new Scanner(System.in);
            while (!validInput) {
                System.out.println("  ");
                System.out.println("Please enter a number 0-8  " + currentPlayer.player);

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
                            Main.winner = currentPlayer.player;
                            break;
                        }

                        currentPlayer = player2;



                    }

                    if (ai) {
                        Random random = new Random();
                        int randomInt = random.nextInt(9);
                        game2.changeValue(game2.getGameBoard(), randomInt, currentPlayer);


                        checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            break;
                        }
                        currentPlayer = player1;
                    }

                    if (currentPlayer == player2 && !ai) {
                        System.out.println("  ");
                        System.out.println("Please enter a number 0-8  " + currentPlayer.player);

                        strInput = input.nextLine();
                        currentPlayerInput = Integer.parseInt(strInput);

                        game2.changeValue(game2.getGameBoard(), currentPlayerInput, currentPlayer);

                        Arrays.stream(game2.getGameBoard()).forEach(System.out::print);

                        checkGame1 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner = currentPlayer.player;
                            break;
                        }

                        currentPlayer = player1;

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
        currentPlayer = player1;
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
                System.out.println("Please enter a number 0-41" + currentPlayer.player);
                strInput = input.nextLine();

                try {
                    currentPlayerInput = Integer.parseInt(strInput);
                    validInput = true;

                    if (currentPlayer == player1) {
                        game3.changeValue(game3.getGameBoard(), currentPlayerInput, currentPlayer);

                        Arrays.stream(game3.getGameBoard()).forEach(System.out::print);
                        checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());

                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner = currentPlayer.player;
                        }

                        currentPlayer = player2;

                    }
                    //check to see if ai ==true and if current player ==ai
                    if (ai) {
                        Random random = new Random();
                        int randomInt = random.nextInt(42);
                        game3.changeValue(game3.getGameBoard(), randomInt, currentPlayer);


                        checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());
                        currentPlayer = player1;
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner = currentPlayer.player;
                            break;
                        }



                    }
                    if (currentPlayer == player2 && !ai) {
                        System.out.println("  ");
                        System.out.println("Please enter a number 0-41  " + currentPlayer.player);
                        String strInput2;
                        strInput2 = input.nextLine();
                        currentPlayerInput = Integer.parseInt(strInput2);

                        game3.changeValue(game3.getGameBoard(), currentPlayerInput, currentPlayer);

                        Arrays.stream(game3.getGameBoard()).forEach(System.out::print);

                        checkGame1 = new GameLogicFlow().GameOver(toArray1, toArray1[0].getGame());
                        if (checkGame1) {
                            System.out.println("\n" + currentPlayer.player + "  won");
                            Main.winner = currentPlayer.player;
                            break;
                        }

                        currentPlayer = player1;

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
