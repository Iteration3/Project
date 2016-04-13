package models.Skill.SmasherSkill;
import models.Entity.*;
import models.Skill.*;
import java.util.Map;


public class SmasherSkill extends Skill {

    private double strengthOfAttackModifier;

    public SmasherSkill(String name, double manaCost, double strengthOfAttackModifier) {
        super(name, manaCost);
        this.strengthOfAttackModifier = strengthOfAttackModifier;
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

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 5 * strengthOfAttackModifier;
    }

}
