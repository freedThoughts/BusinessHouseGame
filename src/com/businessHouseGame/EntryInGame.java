package com.businessHouseGame;

import com.businessHouseGame.model.BusinessHouse;

import java.util.Scanner;

public class EntryInGame {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        BusinessHouse businessHouse = new BusinessHouse(scanner);

        System.out.println("\t\t Welcome to Business House Game");
        System.out.println("\t How many players want to play");
        int numberOfPlayers = 0;
        while (numberOfPlayers == 0) {
            try {
                numberOfPlayers = Integer.valueOf(scanner.nextLine().split(" ")[0]);
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter the number of players, want to play. \n\t Please try again");
            }
        }

        String[] playersNames = new String[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter the name of player number : " + (Integer)(i+1));
            playersNames[i] = scanner.nextLine();
        }

        businessHouse.addPlayers(playersNames);
        System.out.println(" Starting the game ");
        businessHouse.startGame();
    }
}
