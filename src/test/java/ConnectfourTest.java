import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectfourTest {

    @Test
    void changeValue() {
        TicTacToe game3 = new TicTacToe();
        int gridID = 2; //this is the id of the

        GamePiece[] toArray = new GamePiece[9];

        // array representing of  tictactoe object
        for (int i = 0; i < game3.toArray(game3.getGameBoard()).size(); i++) {
            toArray[i] = game3.toArray(game3.getGameBoard()).get(i);
        }
        Players player1 = new Players("wid","o | ");
        game3.changeValue(game3.getGameBoard(), gridID,player1);
        assertEquals("o | ", toArray[gridID].toString());
    }
}