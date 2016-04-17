package models.Map;

import models.AreaEffect.AreaEffect;
import models.Entity.Entity;
import models.Item.Item;
import models.Item.ItemFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;

//Tile is just a contianer
public class Tile implements Saveable {

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

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("tile");
        element.appendChild(terrain.generateXml(doc));

        Element entityContainer = doc.createElement("entity");
        element.appendChild(entityContainer);
        if (entity != null) {
            entityContainer.appendChild(entity.generateXml(doc));
        }

        Element areaEffectContainer = doc.createElement("areaEffect");
        element.appendChild(areaEffectContainer);
        if (areaEffect != null) {
            areaEffectContainer.appendChild(areaEffect.generateXml(doc));
        }

        Element itemContainer = doc.createElement("item");
        element.appendChild(itemContainer);
        if (item != null) {
            itemContainer.appendChild(item.generateXml(doc));
        }
        return element;
    }

    public static Tile fromXmlElement(Element tile) {
        Terrain terrain = Terrain.fromXmlElement((Element) tile.getElementsByTagName("terrain").item(0));
        Tile t = new Tile(terrain);

        Element entityContainer = (Element) tile.getElementsByTagName("entity").item(0);
        if (entityContainer.hasChildNodes()) {
            t.entity = Entity.fromXmlElement((Element) entityContainer.getFirstChild());
        }

        Element areaEffectContainer = (Element) tile.getElementsByTagName("areaEffect").item(0);
        if (areaEffectContainer.hasChildNodes()) {
            t.areaEffect = AreaEffect.fromXmlElement((Element) areaEffectContainer.getFirstChild());
        }

        Element itemContainer = (Element) tile.getElementsByTagName("item").item(0);
        if (itemContainer.hasChildNodes()) {
            t.item = ItemFactory.fromXmlElement((Element) itemContainer.getFirstChild());
        }
        return t;
    }
}


