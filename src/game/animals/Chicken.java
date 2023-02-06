package game.animals;

public class Chicken extends Animal{
    Integer eggsPerWeek = 6;
    Boolean tookProducts = false;
    Integer minWeeksForEggsAndMating = 20;
    public Chicken(String name, Integer weekAge, Double value) {
        super(name, weekAge, 521, 261, 100.0);
    }
    public Integer getProducts(){
        if(weekAge < minWeeksForEggsAndMating){
            return 0;
        }
        if(tookProducts){
            return 0;
        }
        tookProducts = true;
        return eggsPerWeek;
    }
    @Override
    public void newWeek(){
        weekAge += 1;
        tookProducts = false;
    }
    public Boolean canMate(){
        if(weekAge < minWeeksForEggsAndMating){
            return false;
        }
        return true;
    }

}
