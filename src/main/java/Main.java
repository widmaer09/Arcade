import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static String winner;
    public static int numberGames=0;


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
            System.out.println("1 for  1 player");
            System.out.println("2 for two players");
            inputNum = input.nextLine();

            try {
                inputNumPlayers = Integer.parseInt(inputNum);
                selectPlayers = true;
            } catch (Exception e) {
                System.out.println("That is not a Number");
            }
        }
        System.out.println("What is Your name Player 1:");
        strInput = input.nextLine();


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
            player1 = new Players(strInput, TicTacToe.token1);
            if (inputNumPlayers == 1) {


                player2 = new Players("CPU", TicTacToe.token2);
                ai = true;
            }
            GameLogic.game1(new TicTacToe(),
                    player1,
                    player2,
                    currentPlayer = new Players(null, null),
                    ai);//using a generic

        } else if (currentGameInput == 1) {
            player1 = new Players(strInput, Connectfour.token1);
            if (inputNumPlayers == 1) {

                player2 = new Players("CPU", Connectfour.token2);
                ai = true;
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
        emps.put("Game"+numberGames,gameSummary);

        JSONObject empObj = new JSONObject();
        empObj.put("Score Board",emps);

        JSONArray emplist = new JSONArray();
        emplist.put(empObj);

        try(FileWriter file = new FileWriter("package.json")){
            file.write(emplist.toString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


