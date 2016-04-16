package models.StateModel;

import models.Direction.Direction;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Map.MapEditor.MapOperator;
import utilities.Location.Location;
import utilities.State.State;
import views.other.MapView;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateModel implements StateModel{

    private Entity focus;
    private Avatar avatar;
    private MapOperator mapOperator;

    public PlayStateModel() {
        mapOperator = new MapOperator(20,20,10);

        //avatar = new Avatar();
        mapOperator.addNewEntityAt(avatar,new Location(0,0,0));

        setDefaultFocus();
    }

    @Override
    public State nextState() {
        return null;
    }


    @Override
    public void update() {

    }


    public void setDefaultFocus(){
        setFocus(avatar);
    }
    public void setFocus(Entity focus){
        this.focus = focus;
    }
    public Entity getFocus(){return focus;}

    public Avatar getAvatar(){return avatar;}
    public MapView getMapView(){return mapOperator.getMapView();}

    //TODO:fast function, remove
    public void setFocusDirection(Direction dir){
        //avatar.setDirection(dir);
        //avatar.setAction(Action.Move);
    }
}
