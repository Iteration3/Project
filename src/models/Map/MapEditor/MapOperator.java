package models.Map.MapEditor;


import models.Entity.Entity;
import models.Map.*;
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
        map = new Map(maxRowSize,maxColSize,maxHeightSize);
        init();
    }

    public void init() {
        int row = map.getRowSize();
        int col = map.getColSize();
        int height = map.getHeightSize();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int h = 0; h < height; h++) {
                    Location loc = new Location(r, c, h);

                    Random rng = new Random();
                    double random =   rng.nextGaussian();

                    if (random < -0.5) {
                        map.addTileAt(new Tile(new MountainTerrain(DrawTerrainImages.getMountainImage())),loc);
                    } else if (random < 1) {
                        map.addTileAt(new Tile(new GroundTerrain(DrawTerrainImages.getGrassImage())),loc);
                    }
                    else {
                        map.addTileAt(new Tile(new GroundTerrain(DrawTerrainImages.getAirImage())),loc);
                    }
                }
            }
        }
    }


    public boolean addNewEntityAt(Entity entity, Location loc){
        Tile tile = map.getTileAt(loc);

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
