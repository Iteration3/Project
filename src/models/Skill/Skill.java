package models.Skill;

import java.util.Map;
import models.Entity.*;

public abstract class Skill {

    protected int level;
    protected String name;
    protected double manaCost;
    protected double calculatorMultiplier;
    protected double manaCostMultiplier;
    protected int radius;

    public Skill(String name, double manaCost) {
        this.name = name;
        this.level = 1;
        this.calculatorMultiplier = 5;
        this.manaCostMultiplier = 1;
        this.manaCost = manaCost * manaCostMultiplier;

        radius = 3;
    }

    public abstract void activate(Entity entity);

    public boolean canUseSkill(Entity entity) {
        boolean canPerform = canPerform();
        //double hasEnoughMana = entity.getMana();
        double hasEnoughMana = 100;
        if (hasEnoughMana >= manaCost && canPerform) {
            Map<String, Double> modifyManaCostMap = getManaCostMap();
            entity.modifyStats(modifyManaCostMap);
            return true;
        }
        return false;
    }

    protected Map<String, Double> getManaCostMap() {
        Map<String, Double> manaCostMap = null;
        double manaCost = getManaCost();
        manaCostMap.put("mana", -manaCost);
        return manaCostMap;
    }

    protected boolean canPerform() {
        double random = Math.random() * 100;
        if (level * 20 > random) {
            return true;
        }
        return false;
    }

    public int getRadius() {
        return radius;
    }

    public void levelUpSkill() {
        level++;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setManaCost(double manaCost) {
        this.manaCost = manaCost;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getManaCost() {
        return manaCost;
    }

    public int getLevel() {
        return level;
    }

    public void printSkill() {
        System.out.println("Name: " + getName() + "\nMana Cost: " + getManaCost() + "\nLevel: " + getLevel());
    }

}
