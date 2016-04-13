package Skill.BasicSkill;
import Entity.*;
import java.util.Map;


public class BindWounds extends BasicSkill {

    public BindWounds() {
        super("Bind Wounds", 5, "hp");
    }

    public void activate(Entity entity) {
        Map<String, Double> healAmountMap = getHealAmountMap();
        entity.modifyStats(healAmountMap);
    }

    public Map<String, Double> getHealAmountMap() {
        Map<String, Double> map = null;
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

}
