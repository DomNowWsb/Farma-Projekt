package game.buildings;

import game.plants.Plant;

public class Land extends Building {
    Plant plant = null;
    public Land(String name, Double value) {
        super(name, value, "Farm_Land");
    }
    public Boolean SowPlant(Plant plant){
        if(this.plant != null){
            return false;
        }
        this.plant = plant;
        return true;
    }
    public Double harvestPlant(){
        Double harvest = plant.harvest();
        plant = null;
        return harvest;
    }
    public void newWeek(){
        if(plant != null){
            plant.nextWeek();
        }
    }
    public Plant getPlant(){
        return plant;
    }
}
