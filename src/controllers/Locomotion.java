package controllers;

import models.Entity.Entity;
import models.Map.Map;
import models.Map.Terrain;
import models.Map.Tile;
import utilities.Direction.Direction;
import utilities.Location.Location;

/**
 * Created by clayhausen on 4/15/16.
 */
public abstract class Locomotion {

    private Entity entity;
    private Map map;

    public Locomotion(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    //TODO add description of Locomotion/Terrain interaction
    public void move(Direction direction) {

        boolean tileBlocked = false;

        Location currentLocation = entity.getLocation();
        Location nextLocation = direction.getNextLocation(currentLocation);
        Tile nextTile = map.getTileAt(nextLocation);

        if ( checkForEntities(nextTile) || checkForObstacles(nextTile) ) { tileBlocked = true; }

        if (!tileBlocked) {
            Terrain terrain = nextTile.getTerrain();
            terrain.moveTo(this);
        }

        //this might be wrong
        if(checkForAreaEffects(nextTile)){
            System.out.println("AreaEffect should take effect");
            nextTile.activateAreaEffect(entity);
        }

    }

    public abstract void moveToGround();
    public abstract void moveToMountain();
    public abstract void moveToWater();
    public abstract void moveToAir();

    // Accessor methods
    protected Entity getEntity() { return entity; }
    protected Map getMap() { return map; }

    // Helper methods
    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    private boolean checkForEntities(Tile tile) {

        /*boolean isOccupied = true;

        if ( tile.hasEntity() == false ) { isOccupied = false; }

        return isOccupied;*/

        return tile.hasEntity();

    }

    private boolean checkForAreaEffects(Tile tile){
        return tile.hasAreaEffect();
    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Obstacle is occupying the Tile to be moved to
    private boolean checkForObstacles(Tile tile) {
        /*
        boolean occupied = true;

            if ( tile.getObstacle == null ) { occupied = false; }
            return occupied;

        */
        return false;
    }

}
