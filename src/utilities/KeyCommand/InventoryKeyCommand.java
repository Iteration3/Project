package utilities.KeyCommand;

import controllers.Controller;
import controllers.InventoryViewController;
import models.Entity.Entity;
import models.StateModel.InventoryViewModel;
import utilities.GameStateManager;
import utilities.State.State;

import views.InventoryView;
import views.View;

/**
 * Implemented by Peter Camejo
 */
public class InventoryKeyCommand {
    public class PauseKeyCommand implements KeyCommand {


        private GameStateManager gsm;
        private Entity entity;
        public PauseKeyCommand(GameStateManager gsm , Entity entity){
            this.gsm = gsm;
            this.entity = entity;
        }

        @Override
        public void execute(){
            InventoryViewModel model = new InventoryViewModel(this.entity);
            View view = new InventoryView(500 , 500 , gsm.getCurrentCanvas() , model);
            Controller controller = new InventoryViewController(gsm,model);
            State state = new State(view,controller);
            gsm.changeState(state);

        };
    }
}
