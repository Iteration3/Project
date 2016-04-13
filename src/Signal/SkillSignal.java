package Signal;

import models.Direction.Direction;
import models.Map.*;
import models.Entity.*;
import models.Skill.*;


public abstract class SkillSignal {

    protected Map map;
    protected Entity avatar;

    protected int avatarLocX;
    protected int avatarLocY;
    protected int avatarLocZ;

    protected Direction direction;


    public SkillSignal(Map map, Entity avatar, Skill skill) {
        this.map = map;
        this.avatar = avatar;
        setAvatarLocations();
        useSkill(skill);
    }

    private void setAvatarLocations() {
        avatarLocX = avatar.getLocationX();
        avatarLocY = avatar.getLocationY();
        avatarLocZ = avatar.getLocationZ();
        direction = avatar.getDirection();
    }

    protected abstract void useSkill(Skill skill);

}
