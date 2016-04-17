package utilities.KeyCommand;
import models.Entity.Entity;
import models.Map.Map;
import utilities.Direction.Direction;
import models.Map.Tile;

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

    public MovementKeyCommand(Map map, Entity entity, Direction direction) {
        this.map = map;
        this.entity = entity;
        this.direction = direction;
    }


    @Override
    public void execute() {

        entity.changeDirection(direction);

        boolean canMove = true;
        /* Tile tile = keyMap.getTile( direction );

        if ( checkForEntities() || checkForObstacles() ) {
            canMove = false;
        }
        */

        if ( canMove ) {
            // Terrain terrain = tile.getTerrain();
            // entity.move(terrain);
        }

    }


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    private boolean checkForEntities(Tile tile) {
        /*
        boolean occupied = true;

        if ( tile.getEntity == null ) { occupied = false; }
            return occupied;
         */
            return true;
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
