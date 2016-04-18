package controllers;


import models.Entity.Avatar;
import models.Map.Map;
import models.StateModel.MainMenuModel;
import models.StateModel.PlayStateModel;
import utilities.GameStateManager;
import utilities.KeyCommand.*;
import utilities.State.State;
import views.MainMenuView;
import views.View;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by denzel on 4/16/16.
 */
public class PlayStateController extends Controller {

    private PlayStateModel model;
    private Avatar avatar;
    private Map map;
    boolean inAction;

    long action = 0;

    public PlayStateController(PlayStateModel model, GameStateManager gsm, Avatar avatar){
        super(gsm);
        this.model = model;
        this.avatar = avatar;
        map = model.getMap();
        avatar.setKeyCommand(map);
        keyCommand();
        inAction = false;

        //register them under the GSM for model update
        for(int i=0;i<model.getEntityControllers().size();i++) {
            gsm.registerEntityController(model.getEntityControllers().get(i));
        }
    }

    @Override
    public void loadKeyCommand() {  }

    public void keyCommand() {

        loadKeyMap(avatar.getKeyMap());

        KeyCommand openStats = new StatsKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_K, openStats);

        KeyCommand openSkillTree = new SkillTreeKeyCommand(avatar, gsm);
        keyMap.put(KeyEvent.VK_T, openSkillTree);

        KeyCommand pause = new PauseKeyCommand(gsm, map);
        keyMap.put(KeyEvent.VK_ESCAPE,pause);

    }

    private void loadKeyMap(HashMap<Integer,KeyCommand> newKeyMap){
        for(Entry <Integer,KeyCommand> e: newKeyMap.entrySet()){
            keyMap.put(e.getKey(),e.getValue());
        }
    }
    private void removeKeyMap(Set<Integer> set){
        for(Integer i: set){
            keyMap.remove(i);
        }
    }

    //TODO:REMOVE
    long wait = 0;
    @Override
    public void handleInput(KeyEvent e) {

        long time = System.currentTimeMillis();
        if(time - wait > 200){
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
        }

        if (keyMap.get(e.getKeyCode()) != null) {
            keyMap.get(e.getKeyCode()).execute();
        } else {
            System.out.println("Key mapping does not exist");
        }
    }

    public void updateModel() {
        // If Entity has no lives remaining, transition to death menu
        double lives = avatar.getStatContainer().value("CURRENT_LIVES");
        if (lives <= 0) { deathStateTransition(); }
    }

    private void deathStateTransition() {
        MainMenuModel model = new MainMenuModel();
        View view = new MainMenuView("GAME OVER", 500, 500, gsm.getCurrentView().getCanvas(), model);
        Controller controller = new MainMenuViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);

    }

}
