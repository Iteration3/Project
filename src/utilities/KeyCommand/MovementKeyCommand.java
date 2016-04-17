package utilities.KeyCommand;
import models.Entity.Entity;
import models.Entity.Locomotion;
import models.Map.Map;
import models.Map.Terrain;
import utilities.Direction.Direction;
import models.Map.Tile;
import utilities.Location.Location;

/**
 * Created by clayhausen on 4/13/16.
 */

/** Responsibilities: checks for obstacles preventing Entity unit,
 *  then tells its Entity to move, passing it the Terrain it's moving to.
 */
public class MovementKeyCommand implements KeyCommand {

    private Map map;
    private Entity entity;
    private Direction direction;
    private Locomotion locomotion;

    public MovementKeyCommand(Map map, Entity entity, Direction direction) {
        this.map = map;
        this.entity = entity;
        this.direction = direction;
        this.locomotion = entity.getLocomotion();
    }


    @Override
    public void execute() {

        entity.changeDirection(direction);

        boolean canMove = true;
        Location currentLocation = entity.getLocation();
        Location nextLocation = direction.getNextLocation(currentLocation);
        Tile nextTile = map.getTileAt(nextLocation);

        if ( checkForEntities(nextTile) || checkForObstacles(nextTile) ) {
            canMove = false;
        }


        if ( canMove ) {
            Terrain terrain = nextTile.getTerrain();
            // Locomotion determines whether the Entity can move to the Terrain.
            // If (entity can move)
            //   updateMap()
//            if ( locomotion.move(terrain) ) {
//                Tile oldTile = map.getTileAt(currentLocation);
//                oldTile.removeEntity();
//                nextTile.addEntity(entity);
//            }
        }


    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    private boolean checkForEntities(Tile tile) {

        boolean isOccupied = true;

        if ( tile.hasEntity() == false ) { isOccupied = false; }

        return isOccupied;

    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Obstacle is occupying the Tile to be moved to
    private boolean checkForObstacles(Tile tile) {
        /*
        boolean occupied = true;

            if ( tile.getObstacle == null ) { occupied = false; }
            return occupied;

        */
            return true;
    }

    //TODO update once functionality has been added in Entity and elsewhere
    private boolean checkTerrain() {
        return true;
    }

    // Accessor methods
    protected Map getMap() { return map; }
    protected Entity getEntity() { return entity; }
    protected Direction getDirection() { return direction; }

}
