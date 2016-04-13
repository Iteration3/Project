package models.Skill.SummonerSkill;
import models.Entity.*;
import java.util.Map;


public class Staff extends SummonerSkill {

    public Staff() {
        super("Staff", 0);
    }

    public void activate(Entity entity) {
        Map<String, Double> damageAmountMap = getDamageAmountMap();
        entity.modifyStats(damageAmountMap);
    }

    public Map<String, Double> getDamageAmountMap() {
        Map<String, Double> map = null;
        double modifyAmount = getModifyAmount();
        map.put("hp", -modifyAmount);
        return map;
    }

    private double getModifyAmount() {
        return level * 3 * calculatorMultiplier;
    }
}
