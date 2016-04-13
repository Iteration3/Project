package Skill.SneakSkill;
import Entity.*;

public class DetectRemoveTrap extends SneakSkill {

    public DetectRemoveTrap() {
        super("Detect and Remove Trap", 5);
    }

    public void activate(Entity entity) {
        avatar.addItem(entity.getRandomItem());
    }
}
