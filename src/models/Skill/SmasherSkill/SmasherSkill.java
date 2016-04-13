package models.Skill.SmasherSkill;
import models.Entity.*;
import models.Skill.*;
import java.util.Map;


public class SmasherSkill extends Skill {

    private double strengthOfAttackModifier;
    private double weaponRating;

    public SmasherSkill(String name, double manaCost, double strengthOfAttackModifier) {
        super(name, manaCost);
        this.strengthOfAttackModifier = strengthOfAttackModifier;
        weaponRating = 0;
    }

    public void activate(Entity entity) {
        Map<String, Double> damageMap = getDamageMap();
        entity.modifyStats(damageMap);
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = null;
        double modifyByAmount = getModifyAmount();
        map.put("hp", -modifyByAmount);
        return map;
    }

    public void setRating(double weaponRating) {
        weaponRating = weaponRating;
    }

    public void setRatingToZero() {
        weaponRating = 0;
    }

    protected double getModifyAmount() {
        return level * 5 + weaponRating;
    }

}
