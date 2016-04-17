package models.Signal.SkillSignal;

import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import models.Skill.SummonerSkill.Staff;
import utilities.Direction.Direction;
import utilities.Location.Location;


public abstract class SkillSignal {

    protected Map map;
    protected Entity avatar;
    protected int radius;
    protected int currentRadius;

    protected Location avatarLocation;
    protected Direction direction;


    public SkillSignal(Map map, Entity avatar) {
        //public SkillSignal(Map map, Entity avatar, Skill skill) {
        this.map = map;
        this.avatar = avatar;
        Skill skill = new Staff();
        radius = skill.getRadius();
        currentRadius = 0;
        setAvatarLocations();
        useSkill(skill);
    }

    private void setAvatarLocations() {
        avatarLocation = avatar.getLocation();
        direction = avatar.getDirection();
    }

    protected abstract void useSkill(Skill skill);

}
