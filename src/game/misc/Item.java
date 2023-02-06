package game.misc;

import game.interfaces.Sellable;

public abstract class Item implements Sellable {
    String name = "Item_Name";
    Integer amount = 0;
    Double value = 0.0;
    public Item(String name, Integer amount, Double value){
        this.name = name;
        this.amount = amount;
        this.value = value;
    }
    public void addAmount(Integer amount){
        this.amount += amount;
    }
    public Integer getAmount(){
        return this.amount;
    }
    public Double sell(Integer amount){
        if(this.amount < amount){
            System.out.println("Can't sell more than you have");
            return 0.0;
        }
        return this.value * (double) amount;
    }
}
