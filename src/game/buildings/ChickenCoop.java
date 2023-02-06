package game.buildings;

import game.animals.Animal;
import game.animals.Chicken;

import java.util.ArrayList;
import java.util.Collections;

public class ChickenCoop extends Building{
    ArrayList<Chicken> chickens = new ArrayList<>();
    Integer amntOfEggs = 0;
    Boolean canGetEggs = true;
    Integer maxChickens = 20;
    public ChickenCoop(String name, Double value, Integer maxChickens) {
        super(name, value, "ChickenCoop");
        this.maxChickens = maxChickens;
    }
    public Boolean addChicken(Chicken newChicken){
        if(chickens.size()>= maxChickens){
            System.out.println("Can't have more chickens than there's space for in the Coop");
            return false;
        }
        if(!chickens.contains(newChicken)){
            chickens.add(newChicken);
            return true;
        }
        return false;
    }
    public Boolean addChicken(Integer amountOfChickens){
        if(chickens.size()>= maxChickens){
            System.out.println("Can't have more chickens than there's space for in the Coop");
            return false;
        }
        for (int i = 0; i < amountOfChickens; i++) {
            Chicken newChicken = new Chicken("Chicken", 1, 100.0);
            chickens.add(newChicken);
        }
        return true;
    }
    public Boolean addChicken(){
        if(chickens.size()>= maxChickens){
            System.out.println("Can't have more chickens than there's space for in the Coop");
            return false;
        }
        Chicken newChicken = new Chicken("Chicken", 1, 100.0);
        chickens.add(newChicken);
        return true;
    }
    public Boolean addAnimal(Animal newAnimal){
        Chicken newChicken;
        try{
            newChicken = (Chicken) newAnimal;
        }
        catch(ClassCastException e){
            return false;
        }
        return addChicken((Chicken) newAnimal);
    }
    public ArrayList<Chicken> getChickens(){
        return chickens;
    }
    public void newWeek(){
        for (Chicken i: chickens) {
            i.newWeek();
        }
        getProducts();
    }
    public void getProducts(){
        if(!canGetEggs){
            return;
        }
        for (Chicken i: chickens){
            amntOfEggs += i.getProducts();
        }
    }
    public void mateChickens(){
        if(chickens.size() >= maxChickens){
            System.out.println("Can't mate chickens if there's no space in Coop");
            return;
        }
        ArrayList<Boolean> chickensReadyToMate = new ArrayList<>();

        for (Chicken i: chickens) {
            chickensReadyToMate.add(i.canMate());
        }
        int occurrences = Collections.frequency(chickensReadyToMate, true);
        for (int i = 0; i < occurrences; i++) {
            Chicken newChicken = new Chicken("Chicken", 1, 100.0);
            chickens.add(newChicken);
        }
        canGetEggs = false;
    }

}
