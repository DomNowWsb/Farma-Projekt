package game;

import game.animals.Animal;
import game.animals.Chicken;
import game.buildings.Building;
import game.buildings.ChickenCoop;
import game.buildings.Farm;
import game.misc.Item;

import java.util.ArrayList;

public class Actor {
    String name = "Name";
    Double money = 0.0;
    Integer currentWeek = 12;
    Integer playtimeWeek = 1;
    ArrayList<Farm> farms = new ArrayList<>();

    public Actor(String name, Double money){
        this.name = name;
        this.money = money;
    }
    public Double getMoney(){
        return money;
    }
    public Boolean buyFarm(Farm newFarm){
        if(money < newFarm.getValue()){
            return false;
        }
        farms.add(newFarm);
        return true;
    }
    public Boolean buyChicken(Chicken chicken){
        if(money < chicken.getValue()){
            return false;
        }
        for (Farm i: farms) {
            for (Building j: i.getBuildings()) {
                if(j instanceof ChickenCoop){
                    Boolean chickenAdded = ((ChickenCoop) j).addChicken(chicken);
                    if(chickenAdded){return true;}
                }
            }
        }
        return false;
    }
    public void addFarm(Farm newFarm){
        farms.add(newFarm);
    }
    public ArrayList<Farm> getFarms(){
        return farms;
    }
    public void newWeek(){
        playtimeWeek += 1;
        currentWeek += 1;
        for (Farm i: farms) {
            i.newWeek();
        }
    }
    public void newWeek(Integer weeksToSkip){
        for (int i = 0; i < weeksToSkip; i++) {
            newWeek();
        }
    }
    public Boolean buyBuilding(Building newBuilding){
        if(money < newBuilding.getValue()){
            return false;
        }
        money -= newBuilding.getValue();
        farms.get(0).addBuilding(newBuilding);
        System.out.println("You bought: " + newBuilding);
        return true;
    }
    public Boolean buyAnimal(Animal newAnimal){
        if(money < newAnimal.getValue()){
            return false;
        }
        money -= newAnimal.getValue();
        farms.get(0).addAnimal(newAnimal);
        System.out.println("You bought: " + newAnimal);
        return true;
    }
}
