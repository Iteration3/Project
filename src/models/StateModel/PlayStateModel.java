package models.StateModel;


import models.Entity.Entity;
import models.Entity.NPC;
import models.Entity.Pet;
import models.Map.Map;
import models.Map.MapEditor.MapOperator;
import models.Occupation.Sneak;
import models.Occupation.Summoner;
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

    private Pet pet;

    public PlayStateModel(Entity avatar) {

        this.avatar = avatar;

        //TODO Place any model instantiation here
        Pet pet = new Pet(3,new Sneak());
        NPC npc = new NPC(3,new Summoner());

        mapOperator = new MapOperator(20,20,10);

        focus  = new Location(0,0,0);

        mapOperator.addNewEntityAt(avatar,new Location(43,4,2));

//        mapOperator.addNewEntityAt(pet,new Location(0,1,0));
//        mapOperator.addNewEntityAt(npc, new Location(0,2,0));

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
