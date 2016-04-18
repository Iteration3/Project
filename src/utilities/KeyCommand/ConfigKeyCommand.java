package utilities.KeyCommand;
import controllers.ConfigInterfaceViewController;
import controllers.Controller;
import controllers.SkillTreeViewController;
import models.Entity.Entity;
import models.StateModel.ConfigInterfaceModel;
import models.StateModel.SkillTreeModel;
import utilities.GameStateManager;
import utilities.State.State;
import views.ConfigInterfaceView;
import views.SkillTreeView;
import views.View;


public class ConfigKeyCommand implements KeyCommand {

    private GameStateManager gsm;

    public ConfigKeyCommand(GameStateManager gsm) {
        this.gsm = gsm;
    }


    @Override
    public void execute() {
        ConfigInterfaceModel model = new ConfigInterfaceModel();
        View view = new ConfigInterfaceView(500,500,gsm.getCurrentView().getCanvas(),model, null);
        Controller controller = new ConfigInterfaceViewController(model, gsm);
        State state = new State(view, controller);
        gsm.changeState(state);
    }

}
