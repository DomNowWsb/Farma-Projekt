package game;

import game.animals.Chicken;
import game.animals.Horse;
import game.buildings.ChickenCoop;
import game.buildings.Farm;
import game.buildings.Stable;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void buyBuilding(Actor player, Scanner consoleScanner){
        Boolean boughtBuilding = false;
        Boolean success = false;
        while (!boughtBuilding){
            System.out.println("Your balance is: " + player.getMoney());
            System.out.println("Which building do you want to buy?");
            System.out.println("Stable - stable \nChickenCoop - coop \nTo exit buying building - exit");
            String choice = consoleScanner.nextLine();
            switch (choice.toLowerCase()){
                case "stable":
                    System.out.println(choice);
                    Stable newStable = new Stable("Stable", 1500.0, "Stable");
                    success = player.buyBuilding(newStable);
                    if(success){
                        boughtBuilding = true;
                    }
                    break;
                case "coop":
                    ChickenCoop newChickenCoop = new ChickenCoop("ChickenCoop", 1000.0, 20);
                    success = player.buyBuilding(newChickenCoop);
                    if(success){
                        boughtBuilding = true;
                    }
                    break;
                case "exit":
                    boughtBuilding = true;
                    break;
                default:
                    break;
            }
        }
    }
    public static void buyAnimal(Actor player, Scanner consoleScanner){
        Boolean boughtAnimal = false;
        Boolean success = false;
        while (!boughtAnimal){
            System.out.println("Your balance is: " + player.getMoney());
            System.out.println("Which building do you want to buy?");
            System.out.println("Horse - horse \nChicken - chicken \n To exit buying animals - exit");
            String choice = consoleScanner.nextLine();
            switch (choice.toLowerCase()){
                case "horse":
                    Horse newHorse = new Horse("Stable", 1, 500.0);
                    success = player.buyAnimal(newHorse);
                    if(success){
                        boughtAnimal = true;
                    }
                    break;
                case "chicken":
                    Chicken newChicken = new Chicken("Chicken", 1, 50.0);
                    success = player.buyAnimal(newChicken);
                    if(success){
                        boughtAnimal = true;
                    }
                    break;
                case "exit":
                    boughtAnimal = true;
                    break;
                default:
                    break;
            }
        }
    }
    public ArrayList<Farm> getFarms(Actor player){
        return player.getFarms();
    }

    public void buyFarm(Actor player){
        System.out.println("Your balance is: " + player.getMoney());
        System.out.println("Which farm do you want to buy?");
    }
}
