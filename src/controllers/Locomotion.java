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

    protected Entity entity;
    protected Map map;

    public Locomotion(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    //TODO add description of Locomotion/Terrain interaction
    // Moves Entity one tile forward
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

    public void move(Location location) {

        boolean tileBlocked = false;

        Tile nextTile = map.getTileAt(location);

        if ( checkForEntities(nextTile) || checkForObstacles(nextTile) ) { tileBlocked = true; }

        if (!tileBlocked) {
            Terrain terrain = nextTile.getTerrain();
            terrain.moveTo(this);
        }
    }

    public abstract void moveToGround();
    public abstract void moveToMountain();
    public abstract void moveToWater();
    public abstract void moveToAir();


    /** HELPER METHODS **/
    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    private boolean checkForEntities(Tile tile) {

        return ( tile == null || tile.hasEntity() );

    }

    private boolean checkForAreaEffects(Tile tile){

        return ( tile != null && tile.hasAreaEffect() );

    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Obstacle is occupying the Tile to be moved to
    private boolean checkForObstacles(Tile tile) {

        // Guard for map out of bounds
        if (tile == null) { return true; }
        /*
        boolean occupied = true;

            if ( tile.getObstacle == null ) { occupied = false; }
            return occupied;

        */
        return false;
    }


    // Helper methods
    protected void updateEntityLocation() {
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);
    }

    protected void updateMap() {
        // Get old and new Locations so we can get the Tiles
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);

        // Remove the Entity from the old Tile
        Tile oldTile = map.getTileAt(oldLocation);
        if (oldTile != null) { oldTile.removeEntity(); }
        // Add the Entity to the new Tile
        Tile newTile = map.getTileAt(newLocation);
        if (newTile != null) {
            updateEntityLocation();
            newTile.addEntity(entity);
        }

        System.out.println("Entity's Location: " + entity.getLocation().toString());
    }



}
