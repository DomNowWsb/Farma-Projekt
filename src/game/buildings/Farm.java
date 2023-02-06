package game.buildings;

import game.animals.Animal;

import java.util.ArrayList;

public class Farm extends Building{
    ArrayList<Building> buildings = new ArrayList<>();

    public Farm(String name, Double value, Integer hectares) {
        super(name, value, "Farm");
        addLandHectare(hectares);
    }
    public ArrayList<Building> getBuildings(){
        return buildings;
    }
    public void addBuilding(Building building){
        buildings.add(building);
    }
    public Boolean addAnimal(Animal newAnimal){
        for (Building i: buildings) {
            if(i.addAnimal(newAnimal)){
                return true;
            }
        }
        return false;
    }
    public void addLandHectare(Integer hectares){
        for (int i = 0; i < hectares; i++) {
            Land newHectare = new Land("Farmland", 1000.0);
            buildings.add(newHectare);
        }
    }
    public ArrayList<Land> getFarmLand(){
        ArrayList<Land> farmlands = new ArrayList<>();
        for (Building i: buildings) {
            if(i instanceof Land){
                farmlands.add((Land) i);
            }
        }
        return farmlands;
    }
    public void newWeek(){
        for (Building i: buildings) {
            i.newWeek();
        }
    }

}
