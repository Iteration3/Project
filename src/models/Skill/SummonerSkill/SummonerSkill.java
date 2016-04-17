package models.Skill.SummonerSkill;
import models.Entity.Entity;
import models.Skill.*;

public abstract class SummonerSkill extends Skill {

    public SummonerSkill(String name, double manaCost) {
        super(name, manaCost);
    }

    public abstract void activate(Entity entity);
}
