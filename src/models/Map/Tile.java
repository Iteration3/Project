package models.Map;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.Item;

//Tile is just a contianer
public class Tile {

    private Terrain terrain;
    private Entity entity;
    private AreaEffect areaEffect;
    private Item item;

    private int count;

    public Tile(Terrain terrain){
        setTerrain(terrain);
        entity = null;
        areaEffect = null;
        item = null;
        count = 0;
    }

    //terrain methods
    public Terrain getTerrain(){
        return terrain;
    }
    public void setTerrain(Terrain terrain){
        if(terrain == null){
            this.terrain = Terrain.Air;
        }
        else {
            this.terrain = terrain;
        }
    }

    //Enity
    public void addEntity(Entity entity){
        this.entity = entity;
    }
    public boolean hasEntity(){
        return entity != null;
    }
    public void removeEntity(){
        entity = null;
    }
    public Entity getEntity(){return entity; }

    //AreaEffect
    public void addAreaEffect(AreaEffect areaEffect){
        this.areaEffect = areaEffect;
    }
    public boolean hasAreaEffect(){
        return areaEffect != null;
    }
    public void removeAreaEffect(){
        areaEffect = null;
    }
    public AreaEffect getAreaEffect(){return areaEffect;}

    //Item
    public void addItem(Item item){
        this.item = item;
    }
    public boolean hasItem(){
        return item != null;
    }
    public void removeItem(){
        item = null;
    }
    public Item getItem(){return item; }
}

