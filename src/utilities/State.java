package utilities;

import controllers.Controller;
import views.Canvas;
import views.View;

/**
 * Created by denzel on 4/11/16.
 */
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
    public Controller getController(){return this.viewController;}

    //set the current view based on the Canvas
    public void setActiveView(Canvas canvas){canvas.setCurrentView(view);}
}
