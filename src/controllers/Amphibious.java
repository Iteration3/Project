package controllers;

import models.Entity.Entity;
import models.Map.Map;
import models.Map.Terrain;
import models.Map.Tile;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.HashMap;

/**
 * Created by clayhausen on 4/15/16.
 */
public class Amphibious extends Locomotion {

    public Amphibious(Entity entity, Map map) { super(entity, map); }

    // Can move to Ground
    // If falling, take damage based on movement speed
    @Override
    public void moveToGround() {
        // Falling
        if (entity.getDirection() == Direction.Down) {
            double speed = entity.statValue("Movement");
            HashMap<String, Double> damageMap = null;
            damageMap.put("Movement", speed);
            entity.modifyStats(damageMap);
        }
        updateMap();
    }

    // Cannot move to Mountain; does nothing
    // If falling, kills the Entity instantly
    @Override
    public void moveToMountain() {
        // Falling
        if ( entity.getDirection() == Direction.Down ) {
            HashMap<String, Double> livesMap = new HashMap();
            livesMap.put("Lives", -1d);
            entity.modifyStats(livesMap);
        } else {
            System.out.println("Terrestial Entities cannot move over Mountains");
        }
    }

    // Can move in water
    // No additional behavior if falling
    @Override
    public void moveToWater() {
        updateMap();
    }

    // If the Terrestial Entity moves to an Air tile it falls until it reaches a non-air terrain
    // If it reaches a...
    //      GroundTerrain: The Entity takes damage based on the number of Tiles it fell.
    //      WaterTerrain: The Entity drowns and dies
    //      MountainTerrain: The Entity dies instantly
    // In all cases, its speed increases as it falls, and returns to normal upon landing.
    @Override
    public void moveToAir() {
        Entity entity = getEntity();
        Map map = getMap();

        if ( entity.getDirection() == Direction.Up ) {

            // Maybe implement jump?

        } else {
            updateMap();

            // As the Entity is falling, deal increase speed
            double speedDelta = 5;
            HashMap<String, Double> decrementSpeedMap = new HashMap();
            decrementSpeedMap.put("Movement", speedDelta);

            super.move(entity.getDirection());

            // Leaving recursion...change the movement speed back
            HashMap<String, Double> incrementSpeedMap = new HashMap();
            incrementSpeedMap.put("Movement", speedDelta);
        }
    }


}
