package models.Skill.SneakSkill;
import java.util.HashMap;
import java.util.Map;
import models.Entity.*;

public class RangedWeapon extends SneakSkill {

    private double weaponRating;

    public RangedWeapon() {
        super("Ranged Weapon", 2, 3);
        weaponRating = 0;
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageMap = getDamageMap();
            entity.modifyStats(damageMap);
        }
    }

    public Map<String, Double> getDamageMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return level * 5 + weaponRating ;
    }

    public void setRating(double weaponRating) {
        this.weaponRating = weaponRating;
    }

    public void setRatingToZero() {
        weaponRating = 0;
    }

}
