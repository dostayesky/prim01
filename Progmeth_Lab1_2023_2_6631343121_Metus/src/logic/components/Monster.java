package logic.components;

import exception.BadStatusException;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){

        this.status = status;

    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
    public Monster(String name,Status status) throws BadStatusException{
        status.setHp(Math.max(1,status.getHp()));
        this.name = name;
        this.status = status;
        food = null;
        potion = null;
    }
    public void magicAttack(Player player) throws BadStatusException{
        player.getStatus().setHp(Math.max(0,player.getStatus().getHp()-status.getMagic()));
    }
    public void attack(Player player) throws BadStatusException{
        int damage = Math.max(0,status.getAttack()-player.getStatus().getDurability());
        player.getStatus().setHp(Math.max(0, player.getStatus().getHp()-damage));
    }
}
