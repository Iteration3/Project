package models.Map.MapEditor;


import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Map.Map;
import models.Map.Tile;
import utilities.Location.Location;
import utilities.Load_Save.LoadMap;
import utilities.SaveLoad.XmlGenerator;
import utilities.SaveLoad.XmlReader;
import views.MapView;

import javax.xml.parsers.ParserConfigurationException;

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
    public boolean addNewAreaEffect(AreaEffect ae, Location loc){
        Tile tile = map.getTileAt(loc);
        ae.setLocation(loc);

        if(!tile.hasAreaEffect()){
            tile.addAreaEffect(ae);
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
