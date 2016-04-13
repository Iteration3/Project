package Skill.BasicSkill;
import Entity.*;
import java.util.Map;


public class Bargain extends BasicSkill {

    public Bargain() {
        super("Bargain", 5, "bar");
    }

    public void activate(Entity entity) {
        Map<String, Double> bagainSkillAmountMapModifier = getBargainSkillAmountMap();
        entity.modifyStats(bagainSkillAmountMapModifier);
    }

    public Map<String, Double> getBargainSkillAmountMap() {
        Map<String, Double> map = null;
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

}
