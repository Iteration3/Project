package models.Skill.SummonerSkill;
import models.Entity.Entity;

import java.util.Map;


public class Bane extends SummonerSkill {

    public Bane() {
        super("Bane", 5);
    }

    public void activate(Entity entity) {
        Map<String, Double> damageModifyAmountMap = getDamageMap();
        entity.modifyStats(damageModifyAmountMap);
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = null;
        double modifyAmount = getModifyAmount();
        map.put("hp", -modifyAmount);
        return map;
    }

    private double getModifyAmount() {
        return level * 10 * calculatorMultiplier;
    }
}
