package models.StateModel;


import AI.AIController;
import controllers.NPCController;
import controllers.PetController;
import models.AreaEffect.*;
import models.Entity.Entity;
import models.Entity.NPC;
import models.Entity.Pet;
import models.Map.Map;
import models.Map.MapEditor.MapOperator;
import models.Occupation.Sneak;
import models.Occupation.Summoner;
import utilities.Direction.Direction;
import utilities.Location.Location;
import views.Assets;
import views.MapView;
import views.StatusView;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateModel{

    private Location focus;
    private Entity avatar;
    private MapOperator mapOperator;
    private StatusView statusView;
    private ArrayList<AIController> entityController = new ArrayList<>();

    private Pet pet;

    public PlayStateModel(Entity avatar) {

        this.avatar = avatar;

        //TODO Place any model instantiation here
        Location l = new Location(48,0,0);
        Location l2 = new Location(46,0,0);
       // LoseHealth lh = new LoseHealth(l,20); works
        //GainHealth gh = new GainHealth(l,20); works
        //LevelUp lu = new LevelUp(l,1); works
       // InstantDeath id = new InstantDeath(l); works
       // Teleport tp = new Teleport(l,l2); works
        //Trap tp = new Trap(l); not working yet

        mapOperator = new MapOperator(20,20,10);

        statusView = new StatusView(avatar);

        focus  = new Location(0,0,0);

        //TODO Place any model instantiation here
        Pet pet = new Pet(3,new Sneak());
        PetController petController = new PetController(pet,mapOperator.getMap());
        entityController.add(petController);

        NPC npc = new NPC(3,new Summoner());
        NPCController npcController = new NPCController(npc,mapOperator.getMap());
        entityController.add(npcController);

        mapOperator.addNewEntityAt(avatar,new Location(44,0,0));
        mapOperator.addNewEntityAt(pet,new Location(43,0,0));
//        mapOperator.addNewEntityAt(npc, new Location(44,4,0));

        //setDefaultFocus();
        Assets.init();
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

    public StatusView getStatusView() {
        return statusView;
    }

//    //TODO:fast function, remove
    public void setFocusDirection(Direction dir){
       avatar.changeLocation(dir.getNextLocation(avatar.getLocation()));
        avatar.changeDirection(dir);
        //avatar.setAction(Action.Move);
    }

    //get the entity controllers
    public ArrayList<AIController> getEntityControllers(){
        return entityController;
    }
}
