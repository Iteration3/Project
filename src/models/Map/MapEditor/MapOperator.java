package models.Map.MapEditor;


import models.Entity.Entity;
import models.Map.*;
import utilities.Load_Save.LoadMap;
import utilities.Location.Location;
import views.DrawTerrainImages;
import views.MapView;

import java.util.Random;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class MapOperator {

    private Map map;

    public MapOperator(int maxRowSize, int maxColSize, int maxHeightSize){
       map = LoadMap.loadMap("res/Map/Map.txt");
    }


    public boolean addNewEntityAt(Entity entity, Location loc){
        Tile tile = map.getTileAt(loc);
        entity.setLocation(loc);

        if(!tile.hasEntity()){
            tile.addEntity(entity);
            return true;
        }
        return false;
    }
    public void removeEntity(Entity entity){
        Location loc = entity.getLocation();
        Tile tile = map.getTileAt(loc);

        if(tile != null){
            if(entity.equals(tile.getEntity())){
                tile.removeEntity();
            }
        }
    }



    public MapView getMapView(){

        return new MapView(map);
    }

    public Map getMap() {
        return map;
    }

}
