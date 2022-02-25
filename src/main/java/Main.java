import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static String winner;
    public static int numberGames = 0;

    private static void insert(Connection conn,String player1,String  player2,String  winner) throws SQLException {
        String sql = "INSERT INTO Game(Player1, Player2,Winner) VALUES (?, ?,?)"; try (PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setString(1, player1);
            pstmt.setString(2, player2);
            pstmt.setString(3, winner);
            pstmt.executeUpdate();

        }
    }

    private static void query(Connection conn) throws SQLException {
        String sql = "SELECT Game_id, Player1, Player2,Winner FROM Game";     try (Statement stmt = conn.createStatement();
                                                                                     ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("%d%n%s%n%s%n%s%n",
                        rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));       }
        }
    }


    public static void main(String[] args) {
        boolean ai = false;
        Players player1 = null;
        Players currentPlayer = null;

        Players player2 = null;

        boolean selectPlayers = false;
        Scanner input = new Scanner(System.in);
        int inputNumPlayers = 0;
        String inputNum;
        String strInput;

        while (!selectPlayers) {
            System.out.println("Please enter players 1 or 2");
            System.out.println("1 for  one player");
            System.out.println("2 for two players");
            inputNum = input.nextLine();

            try {
                inputNumPlayers = Integer.parseInt(inputNum);
                selectPlayers = true;
            } catch (Exception e) {
                System.out.println("That is not a Number");
            }
        }


        String inputGame;
        boolean chooseGame = false;
        int currentGameInput = 0;


        while (!chooseGame) {
            System.out.println("Please enter either 0 or 1");
            System.out.println("0 to play tic tac toe");
            System.out.println("1 to play connect 4");
            inputGame = input.nextLine();

            try {
                currentGameInput = Integer.parseInt(inputGame);
                chooseGame = true;
            } catch (Exception e) {
                System.out.println("That is not a Number");
            }
        }


        if (currentGameInput == 0) {
            System.out.println("What is Your name Player 1:");
            strInput = input.nextLine();
            player1 = new Players(strInput, TicTacToe.token1);
            if (inputNumPlayers == 1) {


                player2 = new Players("CPU", TicTacToe.token2);
                ai = true;
            } else if (inputNumPlayers == 2) {
                System.out.println("What is Your name Player 2:");
                strInput = input.nextLine();
                player2 = new Players(strInput, TicTacToe.token2);
            }
            GameLogic.game1(new TicTacToe(),
                    player1,
                    player2,
                    currentPlayer = new Players(null, null),
                    ai);//using a generic


        } else if (currentGameInput == 1) {
            System.out.println("What is Your name Player 1:");
            strInput = input.nextLine();
            player1 = new Players(strInput, Connectfour.token1);
            if (inputNumPlayers == 1) {

                player2 = new Players("CPU", Connectfour.token2);
                ai = true;
            } else if (inputNumPlayers == 2) {
                System.out.println("What is Your name Player 2:");
                strInput = input.nextLine();
                player2 = new Players(strInput, Connectfour.token2);
            }

            GameLogic.game2(new Connectfour(),
                    player1,
                    player2,
                    currentPlayer = player1,
                    ai);
        }


        GameSummary gameSummary = new GameSummary(player1.player, player2.player, winner);
        System.out.println(gameSummary);
        numberGames++;

        JSONObject emps = new JSONObject();
        emps.put("Game" + numberGames, gameSummary);

        JSONObject empObj = new JSONObject();
        empObj.put("Score Board", emps);

        JSONArray emplist = new JSONArray();
        emplist.put(empObj);

        try (FileWriter file = new FileWriter("package.json")) {
            file.write(emplist.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = "jdbc:sqlite:C:\\Program Files\\DB Browser for SQLite\\UseDatabase.db";
        try (Connection conn = DriverManager.getConnection(url)) {



            insert(conn,player1.player,player2.player,winner);
            query(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}


