package Utilities.KeyCommand;
import models.Entity.Entity;
import models.Map.Map;
import Utilities.Direction.Direction;

/**
 * Created by clayhausen on 4/13/16.
 */

public abstract class MovementKeyCommand implements KeyCommand {

    private Map map;
    private Entity entity;
    private Direction direction;


    @Override
    public abstract void execute();


    //TODO modify once Map/Obstacle have been implemented
    // Returns true if an Entity is occupying the Tile to be moved to
    protected boolean checkForEntities() {
        /*
        boolean occupied = true;
        Tile tile = map.getTile( direction );
        if ( map.getEntity == null ) { occupied = false; }
            return occupied;
         */
            return true;
        }


        //TODO modify once Map/Obstacle have been implemented
        // Returns true if an Obstacle is occupying the Tile to be moved to
        protected boolean checkForObstacles() {
        /*
        boolean occupied = true;
            Tile tile = map.getTile( direction );
            if ( map.getObstacle == null ) { occupied = false; }
            return occupied;

        */
            return true;
        }

}
