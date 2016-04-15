package models.StateModel;

import State.State;
import State.TestingState;

/**
 * Created by jcvarela on 4/12/2016.
 */
public class MainMenuModel implements StateModel{

    public enum MainMenuOption{
        Start("Start", new TestingState()),
        NewGame("New Game", new TestingState()),
        Exit("Exit", null);

        private String name;
        private State nextState;

        MainMenuOption(String name, State nextState){
            this.nextState = nextState;
            this.name = name;
        }

        public static MainMenuOption getPrev(MainMenuOption selected){
            int pos = selected.ordinal();
            if(pos == 0){
                return MainMenuOption.values()[MainMenuOption.values().length -1];
            }
            return MainMenuOption.values()[pos -1];
        }
        public static MainMenuOption getAfter(MainMenuOption selected){
            int pos = selected.ordinal();
            if(pos == MainMenuOption.values().length-1){
                return MainMenuOption.values()[0];
            }
            return MainMenuOption.values()[pos + 1];
        }

        public State getNextState(){ return nextState; }

        @Override
        public String toString(){
            return name;
        }
    }

    private MainMenuOption selected;
    private boolean isActive;

    public MainMenuModel(){
        selected = MainMenuOption.Start;
    }


    public MainMenuOption getSelected(){
        return selected;
    }


    public void up(){
        selected = MainMenuOption.getPrev(selected);
    }

    public void down(){
        selected = MainMenuOption.getAfter(selected);
    }

    public void select(){
        isActive = true;
    }

    @Override
    public void update() {

    }

    @Override
    public State nextState() {
        if(isActive){
            State nextState = selected.getNextState();
            if(nextState == null){
                System.exit(0);
            }
            return nextState;
        }
        return null;
    }

}
