package models.Item;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;

import models.Entity.Entity;
import Utilities.Location;

/*
* Implemented by Peter Camejo
*/

public abstract class ConsumableItem extends TakeableItem {
    /* Attributes */
    private Map<String , Double> statModifier;

    /* Constructor */
    public ConsumableItem(){
        super();
    }

    public ConsumableItem(String statName , double modifier , BufferedImage image , int id, Location location, String name){
        super(image, id, location, name);
        statModifier = new LinkedHashMap<>();
        statModifier.put(statName , modifier);
    }

    /* Methods */
    public void use(Entity entity){
        entity.modifyStats(this.statModifier);
    }

}
