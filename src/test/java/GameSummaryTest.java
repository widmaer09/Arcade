import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSummaryTest {

    @Test
    void readOut() {
        GameSummary newGame = new GameSummary("Player1", "Player2", "Player2");
        assertEquals(newGame.getPlayer1(), "Player1");
        assertEquals(newGame.getPlayer2(), "Player2");
        assertEquals(newGame.getWinner(), "Player2");

    }


}