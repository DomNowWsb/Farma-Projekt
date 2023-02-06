import game.Actor;
import game.animals.Horse;
import game.buildings.ChickenCoop;
import game.buildings.Farm;
import game.buildings.Stable;

import java.util.Scanner;


import static game.Game.buyAnimal;
import static game.Game.buyBuilding;

public class Main {
    public static void main(String[] args) {
        Boolean playGame = true;
        System.out.println("Please input your character name");
        Scanner consoleScanner = new Scanner(System.in);
        String playerName = consoleScanner.nextLine();
        Actor player = new Actor(playerName, 100000.0);
        Farm newFarm = new Farm("My_Farm", 200.0, 3);
        ChickenCoop coop = new ChickenCoop("ChickenCoop", 10.0, 20);
        coop.addChicken();
        coop.addChicken();
        newFarm.addBuilding(coop);
        player.addFarm(newFarm);
        Stable newStable = new Stable("Stable", 1000.0, "Stable");
        newFarm.addBuilding(newStable);
        Horse newHorse = new Horse("Horse", 1, 1.0);
        player.buyAnimal(newHorse);
        while (playGame){
            System.out.println("What do you want to do next? Type 'exit' for exiting the game");
            System.out.println("Next week - 1 \nBuy building - 2 \nBuy animal - 3");
            String choice = consoleScanner.nextLine();
            switch (choice){
                case "exit":
                    playGame = false;
                    break;
                case "1":
                    player.newWeek();
                    break;
                case "2":
                    buyBuilding(player, consoleScanner);
                    break;
                case "3":
                    buyAnimal(player, consoleScanner);
                    break;
                default:
                    break;
            }
        }
    }


}