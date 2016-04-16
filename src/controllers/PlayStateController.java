package controllers;

import models.StateModel.PlayStateModel;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateController extends Controller{

    private PlayStateModel model;

    public PlayStateController(PlayStateModel mdoel){
        this.model = mdoel;
    }

    @Override
    public void loadKeyCommand() {

    }
}
