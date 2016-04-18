package models.Skill.SmasherSkill;
import models.Entity.*;
import models.Skill.*;

import java.util.HashMap;
import java.util.Map;


public abstract class SmasherSkill extends Skill {

    private double strengthOfAttackModifier;
    private double weaponRating;

    public SmasherSkill(String name, double manaCost, double strengthOfAttackModifier) {
        super(name, manaCost, 1);
        this.strengthOfAttackModifier = strengthOfAttackModifier;
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageMap = getDamageMap();
            entity.modifyStats(damageMap);
        }
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return level * 5  + weaponRating;
    }

    public void setRating(double weaponRating) {
        this.weaponRating = weaponRating;
    }

    public void setRatingToZero() {
        weaponRating = 0;
    }

}
