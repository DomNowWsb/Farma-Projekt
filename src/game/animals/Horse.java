package game.animals;

public class Horse extends Animal{

    public Horse(String name, Integer weekAge, Double value) {
        super(name, weekAge, 960, 480, 10000.0);
    }
    public void newWeek(){
        this.weekAge += 1;
    }

    @Override
    public Integer getProducts() {
        return null;
    }
}
