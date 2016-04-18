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
        initMap();
    }

    public void initMap(){

        int row = map.getRowSize();
        int col = map.getColSize();
        int height = map.getHeightSize();

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                for(int h =0; h < height; h++){
                    
                    Tile tile = map.getTileAt(new Location(r,c,h));
                    map.addTileAt(tile,new Location(r,c,h));
                }
            }
        }
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
