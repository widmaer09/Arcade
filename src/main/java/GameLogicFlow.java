public class GameLogicFlow {
    // house all the methods with determining the state of the game or if its over


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

        for (int i = 0; i <7; i += 1) {
            //GamePiece[] row = new GamePiece[7];

            if (i == 0||i == 1||i == 2||i == 3||i == 4||i == 5||i == 6){
                GamePiece[] row = {array[i],array[i+7],array[i+14],array[i+21],array[i+28],array[i+35]};

                System.out.println(row[0]);
                System.out.println(row[1]);
                System.out.println(row[2]);
                System.out.println(row[3]);
                System.out.println(row[4]);
                System.out.println(row[5]);
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
        for (int i = 0; i < array.length; i += 2) {
            if (i == 0) {
                String a = array[i].getValue();
                String b = array[i + 4].getValue();
                String c = array[i + 8].getValue();
                if (a.equals(b) && b.equals(c)) {
                    winByDiag1 = true;
                }
            } else if (i == 2) {
                String a = array[i].getValue();
                String b = array[i + 2].getValue();
                String c = array[i + 4].getValue();
                if (a.equals(b) && b.equals(c)) {
                    winByDiag1 = true;
                }
            }
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
        boolean results = false;
        //String result;
        if (game.equals("connectfour")) {
            if (winByHorizontal(array)) {
                result = true;
                //"Won By Horizontal";
            } else if (winByVertical(array)) {
                results = true;
                //"Won by Vertical";
            } else if (winByDiag1(array)) {
                result = false;
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
        return results;
    }
}
