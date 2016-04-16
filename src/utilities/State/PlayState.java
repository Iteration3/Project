package utilities.State;

import controllers.PlayStateController;
import models.StateModel.PlayStateModel;
import views.Assets;
import views.stateView.PlayStateView;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayState extends State{

    @Override
    public void initMVC() {
        PlayStateModel model = new PlayStateModel();
        PlayStateController controller = new PlayStateController(model);
        PlayStateView view = new PlayStateView(model);
        Assets.init();
        super.setMVC(model,view,controller);
    }
}
