import java.util.Arrays;

public class Concurrent {


    public static void main(String[] args) {
        Placements player = new Placements();
        Thread t1 = new Thread(new BoardPlacement(player, 9, false));
        Thread t2 = new Thread(new BoardPlacement(player, 9, true));
        t1.start();
        t2.start();
    }
}

class BoardPlacement implements Runnable {
    private final int max;
    private final Placements player;
    private final boolean isEvenNumber;

    BoardPlacement(Placements player, int max, boolean isEvenNumber) {
        this.player = player;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 1 : 0;
        while (number <= max) {
            if (isEvenNumber) {
                player.player1(number);
            } else {
                player.player2(number);
            }
            number += 2;
        }
    }
}

class Placements {
    private volatile boolean OddNumber;
    TicTacToe game1 = new TicTacToe();
    Players player1 = new Players("player1", "x | ");
    Players player2 = new Players("player2", "o | ");


    synchronized void player1(int number) {
        while (!OddNumber) {
            try {
                wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }
        game1.changeValue(game1.getGameBoard(), number, player1);
        Arrays.stream(game1.getGameBoard()).forEach(System.out::print);

        System.out.println("\n" + "==============================checkGame==============================");


        OddNumber = false;
        notify();
    }

    synchronized void player2(int number) {
        while (OddNumber) {
            try {
                wait();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        game1.changeValue(game1.getGameBoard(), number, player2);
        Arrays.stream(game1.getGameBoard()).forEach(System.out::print);
        System.out.println(" ");
        System.out.println("\n" + "==============================checkGame==============================");
        OddNumber = true;
        notify();
    }
}
