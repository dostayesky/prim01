package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private  ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) throws BadStatusException{
        this.status = status;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(energy,0);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = Math.max(0,money);
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }

    public Player(String name, Status status) {
        try {
            this.name = name;
            status.setHp(Math.max(1, status.getHp()));
            setMoney(100);
            setEnergy(10);
            setFoods(new ArrayList<Food>());
            setPotions(new ArrayList<Potion>());
            setOres(new ArrayList<Ore>());
            setStatus(status);
        }catch (Exception BadStatusException){}

    }
    public Player(String name, Status status, int energy, int money){
        try {
            setName(name);
            status.setHp(Math.max(1, status.getHp()));
            setStatus(status);
            setMoney(money);
            setEnergy(energy);
            setFoods(new ArrayList<Food>());
            setPotions(new ArrayList<Potion>());
            setOres(new ArrayList<Ore>());
        }catch (Exception BadStatusException){}
    }
    public boolean buyOre(Ore ore){
        if (money< ore.getCost()){return false;}
        money -= ore.getCost();
        ores.add(ore);
        return true;
    }
    public void drinkPotion(int index) throws BadStatusException {
        if (!(index>=potions.size() | index<0))  {
            status.addStatus(potions.get(index).getIncreasingStatus());
            potions.remove(index);
        }
    }
    public void eatFood(int index) {
        if (!(index>=foods.size() | index<0))  {
            energy+=foods.get(index).getEnergy();
            foods.remove(index);
        }
    }
    public void sellPotion(int index){
        if (!(index>=potions.size() | index<0)) {
            money += potions.get(index).getPrice();
            potions.remove(index);
        }
    }
    public void sellFood(int index) {
        if (!(index>=foods.size() | index<0))  {
            money += foods.get(index).getPrice();
            foods.remove(index);
        } 
    }
    public void attack(Monster monster) throws BadStatusException{
        int damage = Math.max(0,status.getAttack()-monster.getStatus().getDurability());
        monster.getStatus().setHp(Math.max(0, monster.getStatus().getHp()-damage));
    }
    public void magicAttack(Monster monster) throws BadStatusException{
        monster.getStatus().setHp(Math.max(0,monster.getStatus().getHp()-status.getMagic()));
    }
}
