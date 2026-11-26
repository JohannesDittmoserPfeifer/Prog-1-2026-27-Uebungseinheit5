package at.ac.hcw;

import java.util.Scanner;

import at.ac.hcw.economic.Market;

public class Sim {

    public static void main(String[] args) {
        int haendler;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl Händler: ");
        haendler = scanner.nextInt();
        int rounds;
        System.out.println("Anzahl Rounds: ");
        rounds = scanner.nextInt();
        Market market = new Market(haendler);

        for(int i = 1; i <= rounds; i++){
            market.runRound();
        }
        market.showStatistics();
    }
}
