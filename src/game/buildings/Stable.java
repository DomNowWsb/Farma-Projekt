package game.buildings;

import game.animals.Animal;
import game.animals.Chicken;
import game.animals.Horse;

import java.util.ArrayList;

public class Stable extends Building{
    ArrayList<Horse> horses = new ArrayList<>();
    Integer maxHorses = 10;
    public Stable(String name, Double value, String type) {
        super(name, value, type);
    }
    @Override
    public void newWeek() {
        for (Horse i: horses) {
            i.newWeek();
        }
    }
    public Boolean addHorse(Horse newHorse){
        if(horses.size()>= maxHorses){
            System.out.println("Can't have more horses than there's space for in the Stable");
            return false;
        }
        if(!horses.contains(newHorse)){
            horses.add(newHorse);
            return true;
        }
        return false;
    }
    public Boolean addAnimal(Animal newAnimal){
        Horse newHorse;
        try{
            newHorse = (Horse) newAnimal;
        }
        catch(ClassCastException e){
            return false;
        }
        return addHorse((Horse) newAnimal);
    }
}
