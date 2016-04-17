package controllers;

import models.Entity.Avatar;
import utilities.GameStateManager;
import models.Entity.Entity;
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
    private Map map;

    //Constructor of the AvatarCreationController
    public AvatarViewController(Entity model, Map map, Locomotion locomotion, GameStateManager gsm) {
        super(gsm);
        this.model = model;
        this.map = map;
    }


    @Override
    public void loadKeyCommand() {
        Locomotion locomotion = new Terrestrial(model, map);

        // Movement
        KeyCommand moveNorth = new MovementKeyCommand(map, model, Direction.North, locomotion);
        keyMap.put(KeyEvent.VK_8, moveNorth);

        KeyCommand moveNorthWest = new MovementKeyCommand(map, model, Direction.NorthWest, locomotion);
        keyMap.put(KeyEvent.VK_7, moveNorthWest);

        KeyCommand moveSouthWest = new MovementKeyCommand(map, model, Direction.SouthWest, locomotion);
        keyMap.put(KeyEvent.VK_1, moveSouthWest);

        KeyCommand moveSouth = new MovementKeyCommand(map, model, Direction.South, locomotion);
        keyMap.put(KeyEvent.VK_2, moveSouth);

        KeyCommand moveSouthEast = new MovementKeyCommand(map, model, Direction.SouthEast, locomotion);
        keyMap.put(KeyEvent.VK_3, moveSouthEast);

        KeyCommand moveNorthEast = new MovementKeyCommand(map, model, Direction.NorthEast, locomotion);
        keyMap.put(KeyEvent.VK_9, moveNorthEast);

        KeyCommand moveUp = new MovementKeyCommand(map, model, Direction.Up, locomotion);
        keyMap.put(KeyEvent.VK_SPACE, moveUp);

        KeyCommand moveDown = new MovementKeyCommand(map, model, Direction.Down, locomotion);
        keyMap.put(KeyEvent.VK_ENTER, moveDown);




    }
}
