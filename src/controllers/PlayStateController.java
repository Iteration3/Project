package controllers;

import models.Entity.Avatar;
import models.Entity.Entity;
import models.Map.Map;
import models.StateModel.PlayStateModel;
import utilities.Direction.Direction;
import utilities.GameStateManager;
import utilities.KeyCommand.*;

import java.awt.event.KeyEvent;

/**
 * Created by denzel on 4/16/16.
 */
public class PlayStateController extends Controller {

    private PlayStateModel model;
    private Entity avatar;
    private Map map;

    public PlayStateController(PlayStateModel model, GameStateManager gsm, Entity avatar){
        super(gsm);
        this.model = model;
        this.avatar = avatar;
        map = model.getMap();
        keyCommand();
    }

    @Override
    public void loadKeyCommand() {  }

    public void keyCommand() {

        Locomotion locomotion = new Terrestrial(avatar, map);
        // Movement
        KeyCommand moveNorth = new MovementKeyCommand(map, avatar, Direction.North, locomotion);
        keyMap.put(KeyEvent.VK_8, moveNorth);

        KeyCommand moveNorthWest = new MovementKeyCommand(map, avatar, Direction.NorthWest, locomotion);
        keyMap.put(KeyEvent.VK_7, moveNorthWest);

        KeyCommand moveSouthWest = new MovementKeyCommand(map, avatar, Direction.SouthWest, locomotion);
        keyMap.put(KeyEvent.VK_1, moveSouthWest);

        KeyCommand moveSouth = new MovementKeyCommand(map, avatar, Direction.South, locomotion);
        keyMap.put(KeyEvent.VK_2, moveSouth);

        KeyCommand moveSouthEast = new MovementKeyCommand(map, avatar, Direction.SouthEast, locomotion);
        keyMap.put(KeyEvent.VK_3, moveSouthEast);

        KeyCommand moveNorthEast = new MovementKeyCommand(map, avatar, Direction.NorthEast, locomotion);
        keyMap.put(KeyEvent.VK_9, moveNorthEast);

        KeyCommand moveUp = new MovementKeyCommand(map, avatar, Direction.Up, locomotion);
        keyMap.put(KeyEvent.VK_SPACE, moveUp);

        KeyCommand moveDown = new MovementKeyCommand(map, avatar, Direction.Down, locomotion);
        keyMap.put(KeyEvent.VK_ENTER, moveDown);

        moveNorthWest = new MovementKeyCommand(map, avatar, Direction.NorthWest, locomotion);
        keyMap.put(KeyEvent.VK_Q, moveNorthWest);

        moveSouthWest = new MovementKeyCommand(map, avatar, Direction.SouthWest, locomotion);
        keyMap.put(KeyEvent.VK_A, moveSouthWest);

        moveSouth = new MovementKeyCommand(map, avatar, Direction.South, locomotion);
        keyMap.put(KeyEvent.VK_S, moveSouth);

        moveSouthEast = new MovementKeyCommand(map, avatar, Direction.SouthEast, locomotion);
        keyMap.put(KeyEvent.VK_D, moveSouthEast);

        moveNorthEast = new MovementKeyCommand(map, avatar, Direction.NorthEast, locomotion);
        keyMap.put(KeyEvent.VK_E, moveNorthEast);

        moveNorth = new MovementKeyCommand(map, avatar, Direction.North, locomotion);
        keyMap.put(KeyEvent.VK_W, moveNorth);



        KeyCommand useFireball = new SkillKeyCommand(map, avatar);
        keyMap.put(KeyEvent.VK_F, useFireball);

        KeyCommand openStats = new StatsKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_K, openStats);

        KeyCommand openSkillTree = new SkillTreeKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_T, openSkillTree);

;
    }

    //TODO:REMOVE
    long wait = 0;
    @Override
    public void handleInput(KeyEvent e) {
        long time = System.currentTimeMillis();
        if(time - wait > 500){
            if(keyMap.get(e.getKeyCode())!= null) {
                keyMap.get(e.getKeyCode()).execute();
                wait = time;
            }else{
                System.out.println("Key Mapping Does Not Exist");
            }
        }
    }
}
