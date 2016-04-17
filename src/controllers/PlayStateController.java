package controllers;

import models.StateModel.PlayStateModel;
import utilities.GameStateManager;

/**
 * Created by denzel on 4/16/16.
 */
public class PlayStateController extends Controller {

    private PlayStateModel model;

    public PlayStateController(PlayStateModel model, GameStateManager gsm){
        super(gsm);
        this.model = model;
    }

    @Override
    public void loadKeyCommand() {

        //movement keys

        //inventory key

        //equipment key

        //pause key

    }

}
