package models.Item.Armors;

import models.Item.EquipableItem;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;


import models.Entity.Entity;
import utilities.Location.Location;


/**
 *  Implemented by Peter Camejo
 *
 *  Class is meant to insure that armor pieces are of the type Armor
 */
public abstract class Armor extends EquipableItem {
    /* Constructor */
    public Armor(){
        super();
    }

    public Armor(BufferedImage image , int id, Location location, String name, double rating){
        super(image, id, location, name ,rating);
    }

    public void applyRating(Entity entity){
        Map<String , Double > statModifier =  new LinkedHashMap<>();
        statModifier.put("Armor" , this.rating);
        entity.modifyStats(statModifier);
    }

    public void unapplyRating(Entity entity){
        Map<String, Double> statModifier = new LinkedHashMap<>();
        statModifier.put("Armor" , -this.rating);
        entity.modifyStats(statModifier);
    }

}