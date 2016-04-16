package models.Entity;

import models.Map.Terrain;

/**
 * Created by clayhausen on 4/15/16.
 */
public abstract class Locomotion {

    private Entity entity;

    public abstract void move(Terrain terrain);

    // Accessor methods
    protected Entity getEntity() { return entity; }
}
