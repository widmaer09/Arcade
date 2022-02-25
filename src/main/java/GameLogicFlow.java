import java.util.ArrayList;

public class GameLogicFlow {
    // house all the methods with determining the state of the game or if its over

    private static boolean winByDiag1(GamePiece[][] array){
        boolean winByDiag1= false;

        for(int i = 0; i < array.length; i += 1){

            for (int j = 0; j < array[i].length; j += 1) {
                if (j>=3){
                    String a = array[i][j].getValue();
                    String b = array[i][j-1].getValue();
                    String c = array[i][j-2].getValue();
                    String d =array[i][j-3].getValue();
                    if (a.equals(b) && b.equals(c) && c.equals(d)) {
                        winByDiag1 = true;
                    }

                }

            }

        }
        return winByDiag1;

    }


    public boolean winByHorizontal(GamePiece[] array) {
        boolean Horizontal = false;
        for (int i = 0; i < array.length; i += 7) {
            GamePiece[] row = new GamePiece[7];
            int startIndex = i;
            for (int j = 0; j < row.length; j++) {
                row[j] = array[startIndex];
                startIndex += 1;
            }

            for (int j = 0; j < row.length; j++) {
                if (j >= 3) {
                    String a = row[j].getValue();
                    String b = row[j - 1].getValue();
                    String c = row[j - 2].getValue();
                    String d = row[j - 3].getValue();
                    if (a.equals(b) && b.equals(c) && c.equals(d)) {
                        Horizontal = true;
                    }

                }

            }

        }
        return Horizontal;
    }

    public boolean winByHorizontalt(GamePiece[] array) {
        boolean horizontalt = false;
        for (int i = 2; i < array.length; i += 3) {
            String a = array[i].getValue();
            String b = array[i - 1].getValue();
            String c = array[i - 2].getValue();
            if (a.equals(b) && b.equals(c)) {
                horizontalt = true;
            }
        }
        return horizontalt;

    }

    public boolean winByVertical(GamePiece[] array) {
        boolean winByVertical = false;

        for (int i = 0; i < 7; i += 1) {
            //GamePiece[] row = new GamePiece[7];

            if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                GamePiece[] row = {array[i], array[i + 7], array[i + 14], array[i + 21], array[i + 28], array[i + 35]};


                for (int j = 0; j < row.length; j++) {
                    if (j >= 3) {
                        String a = row[j].getValue();
                        String b = row[j - 1].getValue();
                        String c = row[j - 2].getValue();
                        String d = row[j - 3].getValue();
                        if (a.equals(b) && b.equals(c) && c.equals(d)) {
                            winByVertical = true;
                        }

                    }

                }


            }


        }


        return winByVertical;
    }

    public boolean winByVerticalt(GamePiece[] array) {
        boolean winByVerticalt = false;

        for (int i = 0; i < 3; i++) {
            String a = array[i].getValue();
            String b = array[i + 3].getValue();
            String c = array[i + 6].getValue();
            if (a.equals(b) && b.equals(c)) {
                winByVerticalt = true;
            }
        }
        return winByVerticalt;
    }

    public boolean winByDiag1(GamePiece[] array) {
        boolean winByDiag1 = false;

        GamePiece[] uArray = new GamePiece[]{array[21],array[15],array[9],array[3]};
        GamePiece[] uArray1 = new GamePiece[]{array[28],array[22],array[16],array[10],array[4]};
        GamePiece[] uArray2 = new GamePiece[]{array[35],array[29],array[23],array[17],array[11],array[5],};
        GamePiece[] uArray3 = new GamePiece[]{array[36],array[30],array[24],array[18],array[12],array[6]};
        GamePiece[] uArray4 = new GamePiece[]{array[37],array[31],array[25],array[19],array[4]};
        GamePiece[] uArray5 = new GamePiece[]{array[38],array[32],array[26],array[20]};


        GamePiece[] fArray = new GamePiece[]{array[3],array[11],array[19],array[27]};
        GamePiece[] fArray1 =  new GamePiece[]{array[2],array[10],array[18],array[26],array[34]};
        GamePiece[] fArray2 = new GamePiece[]{array[1],array[9],array[17],array[25],array[33],array[41],};
        GamePiece[] fArray3 = new GamePiece[]{array[0],array[8],array[16],array[24],array[32],array[40],};
        GamePiece[] fArray4 = new GamePiece[]{array[7],array[15],array[23],array[31],array[39]};
        GamePiece[] fArray5 = new GamePiece[]{array[14],array[22],array[30],array[38]};

        GamePiece[][] uArrays = new GamePiece[][]{uArray,uArray1,uArray2,uArray3,uArray4,uArray5 };

        GamePiece[][] fArrays = new GamePiece[][]{fArray,fArray1,fArray2,fArray3,fArray4,fArray5};


        if (winByDiag1(uArrays)||winByDiag1(fArrays)){
            winByDiag1=true;
        }

        return winByDiag1;
    }

    public boolean winByDiag1t(GamePiece[] array) {
        boolean winByDiagt = false;
        for (int i = 0; i < array.length; i += 2) {
            if (i == 0) {
                String a = array[i].getValue();
                String b = array[i + 4].getValue();
                String c = array[i + 8].getValue();
                if (a.equals(b) && b.equals(c)) {
                    winByDiagt = true;
                }
            } else if (i == 2) {
                String a = array[i].getValue();
                String b = array[i + 2].getValue();
                String c = array[i + 4].getValue();
                if (a.equals(b) && b.equals(c)) {
                    winByDiagt = true;
                }
            }
        }
        return winByDiagt;
    }

    public boolean GameOver(GamePiece[] array, String game) {
        boolean result = false;
        //String result;
        if (game.equals("connectfour")) {
            if (winByHorizontal(array)) {
                result = true;
                //"Won By Horizontal";
            } else if (winByVertical(array)) {
                result = true;
                //"Won by Vertical";
            } else if (winByDiag1(array)) {
                result = true;
                //"Won by Diag";
            }
        } else if (game.equals("tictactoe")) {
            if (winByHorizontalt(array)) {
                result = true;
                //"Won By Horizontal";
            } else if (winByVerticalt(array)) {
                result = true;
                //"Won by Vertical";
            } else if (winByDiag1t(array)) {
                result = true;
                //"Won by Diag";
            }
        }
        return result;
    }
}
