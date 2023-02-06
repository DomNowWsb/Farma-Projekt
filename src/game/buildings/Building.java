package game.buildings;

import game.animals.Animal;

public abstract class Building {
    String name = "Building_Name";
    Double value = 0.0;
    String type = "Building_type";
    public Building(String name, Double value, String type){
        this.name = name;
        this.value = value;
        this.type = type;
    }
    public Building(String name, String type){
        this.name = name;
        this.type = type;
    }
    public abstract void newWeek();
    public Double getValue(){
        return this.value;
    }
    public Boolean addAnimal(Animal newAnimal){
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}
