package Skill.SneakSkill;
import java.util.Map;
import Entity.*;

public class RangedWeapon extends SneakSkill {

    public RangedWeapon() {
        super("Ranged Weapon", 2);
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
        return calculatorMultiplier * level * 5 ;
    }

}
