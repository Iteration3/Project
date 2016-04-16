package models.StateModel;

import models.Entity.Avatar;
import models.Map.MapEditor.MapOperator;
import utilities.Location.Location;
import views.MapView;


/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateModel{

    private Location focus;
    private Avatar avatar;
    private MapOperator mapOperator;

    public PlayStateModel() {

        //TODO Instantiate avatar

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
    public Location getFocus(){return focus;}

    public Avatar getAvatar(){return avatar;}
    public MapView getMapView() {
        return mapOperator.getMapView();
    }

//    //TODO:fast function, remove
//    public void setFocusDirection(Direction dir){
//        ((EnittyForTesting)focus).setLocation(dir.getNextLocation(focus.getLocation()));
//        //avatar.setDirection(dir);
//        //avatar.setAction(Action.Move);
//    }
}