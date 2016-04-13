package models.Skill.BasicSkill;
import models.Entity.*;
import java.util.Map;


public class Observation extends BasicSkill {
    public Observation() {
        super("Observation", 5, "obv");
    }

    public void activate(Entity entity) {
        Map<String, Double> observationAmountMap = getObservationAmountMap();
        entity.modifyStats(observationAmountMap);
    }

    public Map<String, Double> getObservationAmountMap() {
        Map<String, Double> map = null;
        double modifyByAmount = getModifyAmount(5);
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount(int distance) {
        double amount = 0;
        double random = Math.random() * 100;
        if (random < level * 20) {
            amount = Math.random() * 20;
        }
        else {
            amount = Math.random() * 30 + 20;
        }
        return calculatorMultiplier * amount * distance * 0.5;
    }
}
