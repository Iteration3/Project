package models.StateModel;

import controllers.PlayStateController;
import models.Entity.Avatar;
import models.Map.Map;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utilities.GameStateManager;
import utilities.SaveLoad.XmlGenerator;
import utilities.SaveLoad.XmlReader;
import utilities.State.State;
import views.PlayStateView;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Andy on 4/16/2016.
 */
public class PauseMenuModel {

    public enum PauseMenuOption{
        Start("Save Game") {
            @Override
            public void performAction(GameStateManager gameStateManager, PauseMenuModel model) {
                String name = JOptionPane.showInputDialog("What should the save file be named?");
                try {
                    new XmlGenerator().saveMapToFile(name, model.map);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong writing the save file.");
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong generating the save file.");
                    e.printStackTrace();
                }
            }
        },
        NewGame("Load Game") {
            @Override
            public void performAction(GameStateManager gameStateManager, PauseMenuModel model) {
                String name = JOptionPane.showInputDialog("What is the save file named?");
                Map map = new XmlReader().readMapFromFile(name);
                if (map == null) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong reading the save file.");
                } else {
                    // go back two levels to remove the old playState
                    gameStateManager.removeState();
                    gameStateManager.removeState();
                    PlayStateModel playModel = new PlayStateModel(map);
                    PlayStateView view = new PlayStateView(500,500, gameStateManager.getCurrentView().getCanvas(), playModel);
                    PlayStateController controller = new PlayStateController(playModel, gameStateManager, (Avatar) playModel.getAvatar());
                    State playState = new State(view,controller);
                    gameStateManager.changeState(playState);
                }
            }
        },
        ControllerSetting("Controller Settings") {
            @Override
            public void performAction(GameStateManager gameStateManager, PauseMenuModel model) {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "This functionality has not been implemented.");
                throw new NotImplementedException();
            }
        },
        Exit("Exit Game") {
            @Override
            public void performAction(GameStateManager gameStateManager, PauseMenuModel model) {
                // TODO: something more graceful maybe
                System.exit(0);
            }
        };

        private String name;

        PauseMenuOption(String name){
            this.name = name;
        }

        public static PauseMenuOption getPrev(PauseMenuOption selected){
            int pos = selected.ordinal();
            if(pos == 0){
                return  PauseMenuOption.values()[PauseMenuOption.values().length -1];
            }
            return  PauseMenuOption.values()[pos -1];
        }
        public static  PauseMenuOption getAfter(PauseMenuOption selected){

            int pos = selected.ordinal();
            if(pos ==  PauseMenuOption.values().length-1){
                return  PauseMenuOption.values()[0];
            }
            return  PauseMenuOption.values()[pos + 1];
        }

        public abstract void performAction(GameStateManager gameStateManager, PauseMenuModel model);

        @Override
        public String toString(){
            return name;
        }

    }

    private PauseMenuOption selected;
    private Map map;

    public PauseMenuModel(Map map) {
        selected = PauseMenuOption.Start;
        this.map = map;
    }


    public PauseMenuOption getSelected(){
        return selected;
    }


    public void up(){
        selected = PauseMenuOption.getPrev(selected);
    }

    public void down(){
        selected = PauseMenuOption.getAfter(selected);
    }

}
