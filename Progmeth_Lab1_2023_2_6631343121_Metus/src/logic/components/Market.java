package logic.components;

import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<Potion> potions;
    private ArrayList<Food> foods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }
    public Market(String name){
        this.name = name;
        foods = new ArrayList<Food>();
        potions = new ArrayList<Potion>();
    }
}
