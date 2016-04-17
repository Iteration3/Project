package models.Skill.BasicSkill;
import models.Entity.*;

import java.util.HashMap;
import java.util.Map;


public class BindWounds extends BasicSkill {

    public BindWounds() {
        super("Bind Wounds", 5, "CURRENT_LIFE");
    }

    public void activate(Entity entity) {
        if (entity != null ) {
            Map<String, Double> healAmountMap = getHealAmountMap();
            entity.modifyStats(healAmountMap);
        }
    }

    public Map<String, Double> getHealAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

}
