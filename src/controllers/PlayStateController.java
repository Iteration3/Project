package controllers;

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
    boolean inAction;

    long action = 0;

    public PlayStateController(PlayStateModel model, GameStateManager gsm, Entity avatar){
        super(gsm);
        this.model = model;
        this.avatar = avatar;
        map = model.getMap();
        keyCommand();
        inAction = false;

        //register them under the GSM for model update
        for(int i=0;i<model.getEntityControllers().size();i++) {
            gsm.registerEntityController(model.getEntityControllers().get(i));
        }
    }

    @Override
    public void loadKeyCommand() {

    }

    public void keyCommand() {

        Locomotion locomotion = new Amphibious(avatar, map);
        // Movement
        KeyCommand moveNorth = new MovementKeyCommand(map, avatar, Direction.North, locomotion);
        //keyMap.put(KeyEvent.VK_8, moveNorth);

        KeyCommand moveNorthWest = new MovementKeyCommand(map, avatar, Direction.NorthWest, locomotion);
        //keyMap.put(KeyEvent.VK_7, moveNorthWest);

        KeyCommand moveSouthWest = new MovementKeyCommand(map, avatar, Direction.SouthWest, locomotion);
        //keyMap.put(KeyEvent.VK_1, moveSouthWest);

        KeyCommand moveSouth = new MovementKeyCommand(map, avatar, Direction.South, locomotion);
        //keyMap.put(KeyEvent.VK_2, moveSouth);

        KeyCommand moveSouthEast = new MovementKeyCommand(map, avatar, Direction.SouthEast, locomotion);
        //keyMap.put(KeyEvent.VK_3, moveSouthEast);

        KeyCommand moveNorthEast = new MovementKeyCommand(map, avatar, Direction.NorthEast, locomotion);
        //keyMap.put(KeyEvent.VK_9, moveNorthEast);


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




        KeyCommand openStats = new StatsKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_K, openStats);

        KeyCommand openSkillTree = new SkillTreeKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_T, openSkillTree);


        KeyCommand skill1 = new SkillKeyCommand(map, avatar, 0);
        keyMap.put(KeyEvent.VK_1, skill1);

        KeyCommand skill2 = new SkillKeyCommand(map, avatar, 1);
        keyMap.put(KeyEvent.VK_2, skill2);

        KeyCommand skill3 = new SkillKeyCommand(map, avatar, 2);
        keyMap.put(KeyEvent.VK_3, skill3);

        KeyCommand skill4 = new SkillKeyCommand(map, avatar, 3);
        keyMap.put(KeyEvent.VK_4, skill4);

        KeyCommand pause = new PauseKeyCommand(gsm);
        keyMap.put(KeyEvent.VK_ESCAPE,pause);

        KeyCommand config = new ConfigKeyCommand(gsm);
        keyMap.put(KeyEvent.VK_P, config);
    }


    

    //TODO:REMOVE
    long wait = 0;
    @Override
    public void handleInput(KeyEvent e) {
       /* long time = System.currentTimeMillis();
        if(time - wait > 500){
            if(keyMap.get(e.getKeyCode())!= null) {
                if (inAction) {
                    // do nothing
                } else {
                    inAction = true;;
                    keyMap.get(e.getKeyCode()).execute();
                    inAction = false;
                }
                wait = time;
            }else{
                System.out.println("Key Mapping Does Not Exist");
            }
        }*/

        if (keyMap.get(e.getKeyCode()) != null) {
            keyMap.get(e.getKeyCode()).execute();
        } else {
            System.out.println("Key mapping does not exist");
        }
    }

    public void updateModel() {

    }
}
