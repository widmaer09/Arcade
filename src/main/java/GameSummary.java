import java.io.*;

public class GameSummary {
    public String getPlayer1() {
        return player1;
    }

    String player1;

    public String getPlayer2() {
        return player2;
    }

    String player2;

    public String getWinner() {
        return winner;
    }

    String winner;

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public GameSummary(String player1, String player2, String winner) {
        setPlayer1(player1);
        setPlayer2(player2);
        setWinner(winner);
    }

    @Override
    public String toString() {
        return "GameSummary{" +
                "player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }


}
