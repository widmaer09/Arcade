import java.util.ArrayList;

public abstract class GameBoardAbstract {

    public abstract GamePiece[] getGameBoard();

    public abstract void assembleGameBoard(GamePiece[] gameBoard);

    public abstract void changeValue(GamePiece[] gameBoard, int id, Players currentPlayer);

    public abstract ArrayList<GamePiece> toArray(GamePiece[] gameBoard);

}
