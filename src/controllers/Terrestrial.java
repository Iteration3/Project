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
public class Terrestrial extends Locomotion {

    public Terrestrial(Entity entity, Map map) { super(entity, map); }

    @Override
    public void moveToGround() {
        Entity entity = getEntity();
        Map map = getMap();

        // Update Entity location
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);

        // Update Map
        Tile oldTile = map.getTileAt(oldLocation);
        oldTile.removeEntity();
        Tile newTile = map.getTileAt(newLocation);
        newTile.addEntity(entity);
    }

    //TODO change functionality
    @Override
    public void moveToMountain() {
        Entity entity = getEntity();
        Map map = getMap();

        // Update Entity location
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);

        // Update Map
        Tile oldTile = map.getTileAt(oldLocation);
        oldTile.removeEntity();
        Tile newTile = map.getTileAt(newLocation);
        newTile.addEntity(entity);
    }

    //TODO change functionality
    @Override
    public void moveToWater() {
        Entity entity = getEntity();
        Map map = getMap();

        // Update Entity location
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);

        // Update Map
        Tile oldTile = map.getTileAt(oldLocation);
        oldTile.removeEntity();
        Tile newTile = map.getTileAt(newLocation);
        newTile.addEntity(entity);
    }

    //TODO change functionality
    @Override
    public void moveToAir() {
        Entity entity = getEntity();
        Map map = getMap();

        // Update Entity location
        Location oldLocation = entity.getLocation();
        Direction direction = entity.getDirection();
        Location newLocation = direction.getNextLocation(oldLocation);
        entity.changeLocation(newLocation);

        // Update Map
        Tile oldTile = map.getTileAt(oldLocation);
        oldTile.removeEntity();
        Tile newTile = map.getTileAt(newLocation);
        newTile.addEntity(entity);
    }
}
