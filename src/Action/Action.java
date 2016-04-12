package Action;

import Entity.Entity;

public interface Action {
    //
    void talk();
    void attack();
    void useSkill(Entity entity);
    void useItem(Entity entity);
}
