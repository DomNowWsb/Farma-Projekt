package game.animals;

public abstract class Animal {
    String name = "Animal_Name";
    Integer weekAge = 1;
    Integer lifespanMaxWeek = 521;
    Integer lifespanMinWeek = 261;
    Double value = 0.0;
    public Animal(String name, Integer weekAge, Integer lifespanMaxWeek, Integer lifespanMinWeek, Double value){
        this.name = name;
        this.weekAge = weekAge;
        this.lifespanMaxWeek = lifespanMaxWeek;
        this.lifespanMinWeek = lifespanMinWeek;
        this.value = value;
    }
    public abstract void newWeek();
    public abstract Integer getProducts();
    public Double getValue(){
        return value;
    }
    @Override
    public String toString() {
        return name;
    }

}
