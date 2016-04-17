package utilities.KeyCommand;
import models.Entity.Entity;
import models.Map.Map;
import models.Signal.SkillSignal.RadialSkill.RadialPlanarSkillSignal;
import models.Signal.SkillSignal.RadialSkill.RadialSkill;
import models.Signal.SkillSignal.RadialSkill.RadialSphericalSkillSignal;
import models.Skill.Skill;
import models.Skill.SummonerSkill.Bane;

/**
 * Created by clayhausen on 4/13/16.
 */

/** Responsibilities: checks for obstacles preventing Entity unit,
 *  then tells its Entity to move, passing it the Terrain it's moving to.
 */
public class SkillKeyCommand implements KeyCommand {

    private Map map;
    private Entity entity;

    public SkillKeyCommand(Map map, Entity entity) {
        this.map = map;
        this.entity = entity;
    }


    @Override
    public void execute() {
        Skill skill = new Bane();
        new RadialPlanarSkillSignal(map, entity, skill);
    }

}
