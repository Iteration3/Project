package Utilities;

import Controller.Controller;
import View.View;

//The state object couples the View and Controller
public class State {

    //The Veggies
    private View view;
    private Controller viewController;

    //Constructor
    public State(View view, Controller viewController){
        this.view = view;
        this.viewController = viewController;
    }

    //get View
    public View getView(){
        return this.view;
    }

    //get Controller
    public Controller getController(){
        return this.viewController;
    }

}
