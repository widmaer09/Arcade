import java.util.ArrayList;
import java.util.Arrays;

public class Connectfour extends GameBoardAbstract implements GameBoardView {
    private GamePiece[] gameBoard = new GamePiece[48];
    public static int fourPosition = 0;

    public static String token1 = "X  | ";
    public static String token2 = "O  | ";
    public static String boarder = "==+===+===+===+===+===+===+===+===";
    public static String gameName = "connectfour";

    @Override
    public GamePiece[] getGameBoard() {
        return gameBoard;
    }



    @Override
    public void assembleGameBoard(GamePiece[] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (i == 0
                    || i == 8
                    || i == 16
                    || i == 24
                    || i == 32
                    || i == 40
                    || i == 48) {// this needs work im trying to find a better way to phrase this
                GamePiece pieceBoard = new GamePiece(boarder, gameName);
                gameBoard[i] = pieceBoard;
            } else {
                if (Connectfour.fourPosition <= 9) {
                    GamePiece piece = new GamePiece(Connectfour.fourPosition + "  | ", Connectfour.fourPosition, "connectfour");
                    fourPosition += 1;
                    gameBoard[i] = piece;

                } else {
                    GamePiece piece = new GamePiece(Connectfour.fourPosition + " | ", Connectfour.fourPosition, "connectfour");
                    fourPosition += 1;
                    gameBoard[i] = piece;

                }

            }
        }


    }


    @Override
    public void changeValue(GamePiece[] gameBoard, int id, Players currentPlayer) {
        for (GamePiece row : gameBoard) {
            if (row.getId() == id) {
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

    public Connectfour() {
        assembleGameBoard(gameBoard);
    }
}
