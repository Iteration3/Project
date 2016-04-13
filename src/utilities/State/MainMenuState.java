package utilities.State;

import controllers.MainMenuViewController;
import models.StateModel.MainMenuModel;
import views.MainMenuView;

/**
 * Created by jcvarela on 4/13/2016.
 */
public class MainMenuState extends State{

    @Override
    public void initMVC() {
        MainMenuModel model = new MainMenuModel();
        MainMenuView view = new MainMenuView(model);
        MainMenuViewController controller = new MainMenuViewController(model);

        setMVC(model,view,controller);
    }
}
