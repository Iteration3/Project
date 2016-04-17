package models.StateModel;

import models.Action.Action;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Map.Map;
import models.Map.MapEditor.MapOperator;
import utilities.Direction.Direction;
import utilities.Location.Location;
import views.MapView;


/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateModel{

    private Location focus;
    private Entity avatar;
    private MapOperator mapOperator;

    public PlayStateModel(Entity avatar) {

        this.avatar = avatar;
        mapOperator = new MapOperator(20,20,10);

        focus  = new Location(0,0,0);

        mapOperator.addNewEntityAt(avatar,new Location(0,0,0));

        //setDefaultFocus();
    }

    public void setDefaultFocus(){
        setFocus(avatar.getLocation());
    }
    public void setFocus(Location focus){
        this.focus = focus;
    }
    public Location getFocus(){return avatar.getLocation();}

    public Entity getAvatar(){return avatar;}
    public MapView getMapView() {
        return mapOperator.getMapView();
    }
    public Map getMap() {
        return mapOperator.getMap();
    }

//    //TODO:fast function, remove
    public void setFocusDirection(Direction dir){
       avatar.changeLocation(dir.getNextLocation(avatar.getLocation()));
        avatar.changeDirection(dir);
        //avatar.setAction(Action.Move);
    }
}
