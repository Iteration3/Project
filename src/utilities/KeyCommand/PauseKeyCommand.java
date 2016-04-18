package utilities.KeyCommand;

import controllers.Controller;
import controllers.PauseMenuController;
import models.Map.Map;
import models.StateModel.PauseMenuModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.PauseMenuView;
import views.View;

/**
 * Created by Andy on 4/17/2016.
 */
public class PauseKeyCommand implements KeyCommand {


    private GameStateManager gsm;
    private Map map;
    public PauseKeyCommand(GameStateManager gsm, Map map){
        this.map = map;
        this.gsm = gsm;
    }

    @Override
    public void execute() {
        PauseMenuModel model = new PauseMenuModel(map);
        View view = new PauseMenuView(500,500,gsm.getCurrentCanvas(),null,model);
        Controller controller = new PauseMenuController(model,gsm);
        State state = new State(view,controller);
        gsm.changeState(state);

    };
}
