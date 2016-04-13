package models.StateModel;

import utilities.State.State;

/**
 * Created by jcvarela on 4/13/2016.
 */
public interface StateModel {
    public void update();
    public abstract State nextState();
}
