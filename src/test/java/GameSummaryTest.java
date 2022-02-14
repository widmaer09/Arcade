import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSummaryTest {

    @Test
    void readOut(GameSummary newGame) {
      newGame = new GameSummary("Player1","Player2","Player 2");
        readOut(newGame);

        assertNotNull(newGame);


    }


}