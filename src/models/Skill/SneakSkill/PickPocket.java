package models.Skill.SneakSkill;
import java.util.Map;
import models.Entity.*;


public class PickPocket extends SneakSkill {

    private Entity avatar;

    public PickPocket() {
        super("Pick Pocket", 10.0);
    }

    public void activate(Entity entity) {
        //avatar.addItem(entity.getRandomItem());
    }

    public boolean canUseSkill(Entity entity) {
        boolean canPerform = canPerform();
        //double hasEnoughMana = entity.getMana();
        double hasEnoughMana = 100;
        if (hasEnoughMana >= manaCost && canPerform) {
            Map<String, Double> modifyManaCostMap = getManaCostMap();
            entity.modifyStats(modifyManaCostMap);
            avatar = entity;
            return true;
        }
        return false;
    }
}
