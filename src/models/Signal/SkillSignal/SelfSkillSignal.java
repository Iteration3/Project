package models.Signal.SkillSignal;

import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;


public class SelfSkillSignal extends SkillSignal {


    public SelfSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
    }

    protected void useSkill(Skill skill) {
        if (skill.canUseSkill(avatar)) {
            skill.activate(avatar);
        }
    }

}
