package game.plants;

public abstract class Plant {
    String name = "Plant_Name";
    Double harvestWeightKG = 0.0;
    Integer lifespanWeekMax = 1;
    Integer weekAge = 1;
    Double value = 0.0;
    Boolean canHarvest = false;
    Boolean harvested = false;
    public Plant(String name, Double harvestWeightKG ,Integer lifespanWeekMax, Integer weekAge, Double value){
        this.name = name;
        this.harvestWeightKG = harvestWeightKG;
        this.lifespanWeekMax = lifespanWeekMax;
        this.weekAge = weekAge;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public Integer getLifespanWeekMax(){
        return this.lifespanWeekMax;
    }
    public Integer getWeekAge(){
        return this.weekAge;
    }
    public Double getValue(){
        return this.value;
    }
    public void nextWeek(){
        weekAge += 1;
        if(weekAge >= lifespanWeekMax){
            canHarvest = true;
        }
    }
    public Boolean getCanHarvest(){
        return canHarvest;
    }
    public Boolean getHarvested(){
        return harvested;
    }
    public Double harvest(){
        if(getCanHarvest() && !getHarvested()){
            return harvestWeightKG;
        }
        return 0.0;
    }

}
