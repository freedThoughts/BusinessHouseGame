package com.businessHouseGame.model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.businessHouseGame.constant.MAX_CHANCES_PER_PLAYER;
import static com.businessHouseGame.constant.MAX_DICE_VALUE;
import static com.businessHouseGame.constant.MIN_DICE_VALUE;

public class BusinessHouse {
    private final Cell[] cells;
    private List<Player> players;
    private final Scanner scanner;

    public BusinessHouse(Scanner scanner){
        this.scanner = scanner;
        cells = new Cell[]{new Empty(), new Empty(), new Jail(), new Hotel(), new Empty(), new Treasure(),
        new Jail(), new Treasure(), new Empty(), new Empty(), new Hotel(), new Jail(), new Treasure(), new Hotel(),
        new Empty(), new Empty(), new Jail(), new Hotel(), new Empty(), new Treasure(), new Jail(), new Treasure(),
        new Empty(), new Empty(), new Hotel(), new Jail(), new Treasure(), new Hotel(), new Jail(), new Empty(),
        new Empty(), new Jail(), new Hotel(), new Empty(), new Treasure(), new Jail(), new Treasure(), new Empty(),
        new Empty(), new Hotel(), new Jail(), new Treasure(), new Empty(), new Hotel(), new Empty()};
    }

    public void startGame(){
        for (int i = 0; i < cells.length; i++)
            cells[i].setCellId(i);

        int diceIndex = 0;
        while (diceIndex < players.size() * MAX_CHANCES_PER_PLAYER) {
            Player playerChance = players.get(diceIndex % players.size());
            System.out.println("Enter the dice for " + playerChance.getName() +" \n\t\t Value should be between 2 to 12" +
                    "\n\t\t Enter N to finish the game");

            String input = scanner.nextLine().split(" ")[0];
            if ("N".equalsIgnoreCase(input)) break;

            int diceValue;

            try {
                diceValue = Integer.parseInt(input);
                if (diceValue < MIN_DICE_VALUE || diceValue > MAX_DICE_VALUE) throw new Exception("Invalid Value");
            } catch (Exception e) {
                System.out.println("Invalid Value " + "\n\t\t Value should be between 2 to 12. Please try again.");
                continue;
            }

            playerChance.setCurrentCell(cells[(playerChance.getCellId() + diceValue) % cells.length]);
            playerChance.execute();
            diceIndex++;
            printPlayersWorth();
        }

        printPlayersWorth();
        System.out.println("\n\n\t\t\t  GAME OVER  ");
    }

    public void addPlayers(String[] playerNames) {
        players = Arrays.stream(playerNames).map(a -> new Player(a, this.cells[0])).collect(Collectors.toList());
        System.out.println(" Below mentioned players available to play Business House Game :- ");
        players.stream().forEach(player -> System.out.println("\t " + player.getName() + " with initial capital of " + player.getWorth()));
        System.out.println();
        System.out.println();
        System.out.println();
    }

    private void printPlayersWorth() {
        System.out.println("\n Players worth :- ");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("\t\t Worth of " + players.get(i).getName() + " is " + players.get(i).getTotalWorth());
        }
        System.out.println();
    }
}
