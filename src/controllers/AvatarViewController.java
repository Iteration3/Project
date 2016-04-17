package controllers;

import models.Entity.Avatar;
import utilities.GameStateManager;
import models.Entity.Entity;
import models.Entity.Locomotion;
import models.Map.Map;
import utilities.Direction.*;
import utilities.GameStateManager;
import utilities.KeyCommand.KeyCommand;
import utilities.KeyCommand.MovementKeyCommand;
import java.awt.event.KeyEvent;


/**
 * Created by clayhausen on 4/16/16.
 */
public class AvatarViewController extends Controller {

    private Entity model;
    private Locomotion locomotion;
    private Map map;

    //Constructor of the AvatarCreationController
    public AvatarViewController(Entity model, Map map, GameStateManager gsm) {
        super(gsm);
        this.model = model;
        this.locomotion = model.getLocomotion();
        this.map = map;
    }


    @Override
    public void loadKeyCommand() {

        // Movement
        KeyCommand moveNorth = new MovementKeyCommand(map, model, Direction.North);
        keyMap.put(KeyEvent.VK_8, moveNorth);

        KeyCommand moveNorthWest = new MovementKeyCommand(map, model, Direction.NorthWest);
        keyMap.put(KeyEvent.VK_7, moveNorthWest);

        KeyCommand moveSouthWest = new MovementKeyCommand(map, model, Direction.SouthWest);
        keyMap.put(KeyEvent.VK_1, moveSouthWest);

        KeyCommand moveSouth = new MovementKeyCommand(map, model, Direction.South);
        keyMap.put(KeyEvent.VK_2, moveSouth);

        KeyCommand moveSouthEast = new MovementKeyCommand(map, model, Direction.SouthEast);
        keyMap.put(KeyEvent.VK_3, moveSouthEast);

        KeyCommand moveNorthEast = new MovementKeyCommand(map, model, Direction.NorthEast);
        keyMap.put(KeyEvent.VK_9, moveNorthEast);

        KeyCommand moveUp = new MovementKeyCommand(map, model, Direction.Up);
        keyMap.put(KeyEvent.VK_SPACE, moveUp);

        KeyCommand moveDown = new MovementKeyCommand(map, model, Direction.Down);
        keyMap.put(KeyEvent.VK_ENTER, moveDown);




    }
}
