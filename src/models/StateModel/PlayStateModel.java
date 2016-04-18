package models.StateModel;

import AI.AIController;
import controllers.NPCController;
import controllers.PetController;
import models.Entity.Avatar;
import models.Entity.Entity;
import models.Map.MapEditor.MapOperator;
import utilities.Direction.Direction;
import utilities.Location.Location;
import models.Entity.NPC;
import models.Entity.Pet;
import models.Map.Map;
import models.Occupation.Sneak;
import models.Occupation.Summoner;
import views.Assets;
import views.MapView;
import views.StatusView;

import java.util.ArrayList;

public class PlayStateModel{

    private Location focus;
    private Entity avatar;
    private MapOperator mapOperator;
    private StatusView statusView;
    private ArrayList<AIController> entityController = new ArrayList<>();
    private Location startLocation;

    private Pet pet;

    public PlayStateModel(Entity avatar) {

        this.avatar = avatar;
        this.startLocation = new Location(44,0,0);

        //TODO Place any model instantiation here
        Pet pet = new Pet(3,new Sneak());
        NPC npc = new NPC(3,new Summoner());
        Location l = new Location(47,0,0);

        Location l2 = new Location(46,0,0);
       // LoseHealth lh = new LoseHealth(l,20); works
        //GainHealth gh = new GainHealth(l,20); works
        //LevelUp lu = new LevelUp(l,1); works
       // InstantDeath id = new InstantDeath(l); works
       // Teleport tp = new Teleport(l,l2); works
        //Trap tp = new Trap(l); //not working yet


        mapOperator = new MapOperator(20,20,10);
        // For observers
        mapOperator.addEntityObserver(avatar);
        mapOperator.addEntityObserver(pet);
        mapOperator.addEntityObserver(npc);

        statusView = new StatusView(avatar);

        focus  = new Location(0,0,0);

        //TODO Place any model instantiation here
        pet = new Pet(3,new Summoner());
        PetController petController = new PetController(pet,mapOperator.getMap(),(Avatar)avatar);
        entityController.add(petController);


        //mapOperator.addNewEntityAt(avatar,new Location(49,0,0));

        //FlowTile ft = new FlowTile(l,10,Direction.South,getMap());
        //mapOperator.addNewAreaEffect(ft,l);

        //mapOperator.addNewEntityAt(avatar,new Location(43,4,2));


        //NPC npc = new NPC(3,new Summoner());
        NPCController npcController = new NPCController(npc,mapOperator.getMap());
        entityController.add(npcController);


        mapOperator.addNewEntityAt(avatar, startLocation);
        mapOperator.addNewEntityAt(pet,new Location(43,0,0));
        mapOperator.addNewEntityAt(npc, new Location(44,4,0));

        //setDefaultFocus();
        Assets.init();
    }

    public PlayStateModel(Map map) {
        mapOperator = new MapOperator(map);
        avatar = map.findAvatar();
        System.out.println(avatar);
        statusView = new StatusView(avatar);
        focus = avatar.getLocation();
        for (Entity e : map.entities()) {
            AIController c = e.createNewController(map);
            if (c != null) {
                entityController.add(c);
            }
        }
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

    public void update() {

    }
}
