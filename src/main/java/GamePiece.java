public class GamePiece {
    private String value;
    private int id;
    private String game;

    public String getGame() {
        return game;
    }

    public GamePiece(String value, int id, String game) {
        this.value = value;
        this.id = id;
        this.game = game;
    }

    public GamePiece(String value, String game) {
        this.value = "\n" + value + "\n";
        this.id = 60;
        this.game = game;
    }

    public String getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

