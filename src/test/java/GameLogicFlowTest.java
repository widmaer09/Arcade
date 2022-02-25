import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicFlowTest {

    @Test
    void winByHorizontalt() {
        TicTacToe game3 = new TicTacToe();
        int gridID = 2; //this is the id of the

        GamePiece[] toArray = new GamePiece[9];

        // array representing of the tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }
        boolean checkGame2 = new GameLogicFlow().winByHorizontalt(toArray);
        assertFalse(checkGame2);
        Players player1 = new Players("wid", "o | ");
        game3.changeValue(game3.getGameBoard(), 0, player1);
        game3.changeValue(game3.getGameBoard(), 1, player1);
        game3.changeValue(game3.getGameBoard(), 2, player1);

        //checkGame2 = new GameLogicFlow().winByHorizontalt(toArray);

        //assertTrue(checkGame2);

    }

    @Test
    void winByVerticalt() {
        TicTacToe game3 = new TicTacToe();
        int gridID = 2; //this is the id of the

        GamePiece[] toArray = new GamePiece[9];

        // array representing of the tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }
        Players player1 = new Players("wid", "o | ");
        game3.changeValue(game3.getGameBoard(), 0, player1);
        game3.changeValue(game3.getGameBoard(), 3, player1);
        game3.changeValue(game3.getGameBoard(), 6, player1);

        boolean checkGame2 = new GameLogicFlow().winByVerticalt(toArray);

        assertTrue(checkGame2);


    }

    @Test
    void winByDiag1t() {
        TicTacToe game3 = new TicTacToe();


        GamePiece[] toArray = new GamePiece[9];

        // array representing of the tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }

        Players player1 = new Players("wid", "o | ");


        game3.changeValue(game3.getGameBoard(), 2, player1);
        game3.changeValue(game3.getGameBoard(), 4, player1);
        game3.changeValue(game3.getGameBoard(), 6, player1);

        boolean checkGame2 = new GameLogicFlow().winByVerticalt(toArray);

        assertTrue(checkGame2);
    }

    @Test
    void gameOver() {
        TicTacToe game3 = new TicTacToe();
        int gridID = 2; //this is the id of the

        GamePiece[] toArray = new GamePiece[9];

        // array representing of the tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }
        Players player1 = new Players("wid", "o | ");

        game3.changeValue(game3.getGameBoard(), 0, player1);
        game3.changeValue(game3.getGameBoard(), 3, player1);
        game3.changeValue(game3.getGameBoard(), 6, player1);

        boolean checkGame2 = new GameLogicFlow().GameOver(toArray, toArray[0].getGame());

        assertTrue(checkGame2);


    }

    @Test
    void winByVertical() {
        TicTacToe game3 = new TicTacToe();
        GamePiece[] toArray = new GamePiece[9];

        // array representing of the tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }

        Players player1 = new Players("wid", "o | ");


    }
}