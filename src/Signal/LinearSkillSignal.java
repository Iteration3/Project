package Signal;

import models.Map.*;
import models.Entity.*;
import models.Skill.*;


public class LinearSkillSignal extends SkillSignal {


    public LinearSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
    }

    protected void useSkill(Skill skill) {
        if (skill.canUseSkill(avatar)) {
            for (int i = 0; i < skill.getRadius(); ++i) {
                //Location nextLocation = getNextLocation();
            }
        }
    }


}
