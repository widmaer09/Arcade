import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToe extends GameBoardAbstract implements GameBoardView {

    public static String token1 = "x | ";
    public static String token2 = "o | ";

    private GamePiece[] gameBoard = new GamePiece[12];

    public GamePiece[] getGameBoard() {
        return gameBoard;
    }

    public static int tictactoeposition = 0;


    @Override
    public void assembleGameBoard(GamePiece[] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (i == 4 || i == 8 || i == 0) {// this needs work im trying to find a better way to phrase this
                GamePiece pieceBoard = new GamePiece("==+===+===+=", "tictactoe");
                gameBoard[i] = pieceBoard;
            } else {
                GamePiece piece = new GamePiece(TicTacToe.tictactoeposition + " | ", TicTacToe.tictactoeposition, "tictactoe");
                tictactoeposition += 1;

                gameBoard[i] = piece;
            }
        }
    }

    @Override
    public void changeValue(GamePiece[] gameBoard, int id, Players currentPlayer) {
        // this will be able to interact with the array
        for (GamePiece row : gameBoard) {
            if (row.getId() == id && !(row.getValue() == token1) && !(row.getValue() == token2)) {
                row.setValue(currentPlayer.playerValue);
            }
        }
    }

    @Override
    public ArrayList<GamePiece> toArray(GamePiece[] gameBoard) {
        ArrayList<GamePiece> toArray = new ArrayList<GamePiece>();
        for (GamePiece row : gameBoard) {
            if (row.getId() != 60) {
                toArray.add(row);
            }
        }
        return toArray;
    }

    @Override
    public void printGameBoard(GamePiece[] gameBoard) {
        Arrays.stream(gameBoard).forEach(System.out::println);
    }

    public TicTacToe() {
        //this constructor just makes a tic tac toe board that you interact with
        assembleGameBoard(gameBoard);

    }
}
