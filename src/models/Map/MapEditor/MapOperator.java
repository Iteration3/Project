package models.Map.MapEditor;


import models.Entity.Entity;
import models.Map.Map;
import models.Map.Terrain;
import models.Map.Tile;
import utilities.Load_Save.LoadMap;
import utilities.Location.Location;
import views.other.MapView;

import java.util.Random;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class MapOperator {

    private Map map;

    public MapOperator(int maxRowSize, int maxColSize, int maxHeightSize){
        map = LoadMap.loadMap("res\\Map\\Map.txt");
        //map = new Map(maxRowSize,maxColSize,maxHeightSize);
        //init();
    }

    public void init() {
        int row = map.getRowSize();
        int col = map.getColSize();
        int height = map.getHeightSize();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int h = 0; h < height; h++) {

                    Location loc = new Location(r, c, h);

                    Location x = loc.add(0,0,-1);
                    Tile temp = map.getTileAt(x);

                    if(temp != null){
                       if(temp.getTerrain() == Terrain.Air || temp.getTerrain() == Terrain.Grass) {
                           map.addTileAt(new Tile(Terrain.Air), loc);
                           continue;
                       }
                    }


                    Random rng = new Random();
                    double random =   rng.nextGaussian();

                    random -= (3 - 0.7*h);

                    if (random < 0) {
                        map.addTileAt(new Tile(Terrain.Mountain),loc);
                    } else {
                        map.addTileAt(new Tile(Terrain.Grass),loc);
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


    public static void main(String[] args) {
        Random rng = new Random();

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        double c1 = 1.4;
        double c2 = 3;

        for(int i = 0 ; i < 100000; i++){
            double random =   rng.nextGaussian();

            if(random  < c1 && random > -c1)
                count1++;

            else if(random  < c2 && random > -c2)
                count2++;

            else count3++;

        }

        System.out.println("count 1 " + count1);
        System.out.println("count 2 " + count2);
        System.out.println("count 3 " + count3);
    }
}
