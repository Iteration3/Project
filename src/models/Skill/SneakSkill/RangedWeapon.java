package models.Skill.SneakSkill;
import java.util.Map;
import models.Entity.*;

public class RangedWeapon extends SneakSkill {

    private double weaponRating;

    public RangedWeapon() {
        super("Ranged Weapon", 2);
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

    protected double getModifyAmount() {
        return level * 5 + weaponRating;
    }

    public void setRating(double weaponRating) {
        this.weaponRating = weaponRating;
    }

    public void setRatingToZero() {
        weaponRating = 0;
    }
}
