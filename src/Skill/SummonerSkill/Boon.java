package Skill.SummonerSkill;
import Entity.*;
import java.util.Map;


public class Boon extends SummonerSkill {

    public Boon() {
        super("Boon", 15);
    }

    public void activate(Entity entity) {
        Map<String, Double> statsBuffMap = getStatsBuffMap();
        entity.modifyStats(statsBuffMap);
    }

    public Map<String, Double> getStatsBuffMap() {
        Map<String, Double> map = null;
        double modifyAmountArray[] = getModifyAmount();
        map.put("int", modifyAmountArray[0]);
        map.put("hard", modifyAmountArray[1]);
        map.put("mov", modifyAmountArray[2]);
        return map;
    }

    private double[] getModifyAmount() {
        double modifyAmountArray[] = new double[3];
        //partial immunities?
        modifyAmountArray[0] = 10 * level;
        modifyAmountArray[1] = 20 * level;
        modifyAmountArray[2] = 2 * level;
        return modifyAmountArray;
    }
}
