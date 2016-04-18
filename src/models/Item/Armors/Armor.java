package models.Item.Armors;

import models.Entity.Entity;
import models.Item.EquipableItem;

import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;

import models.Item.Requirement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 *  Implemented by Peter Camejo
 *
 *  Class is meant to insure that armor pieces are of the type Armor
 */
public abstract class Armor extends EquipableItem {
    /* Attributes */
    protected Requirement requirement;

    /* Constructor */
    public Armor(){
        super();
        requirement = new Requirement();
    }

    //No Level requirement
    public Armor(BufferedImage image , int id, String name, double rating){
        super(image,id,name,rating);
        requirement = new Requirement();
    }

    public Armor(BufferedImage image , int id, String name, double rating , int requiredLevel){
        super(image,id,name,rating);
        requirement = new Requirement(null , requiredLevel , null);
    }

    public void applyRating(Entity entity){
        Map<String , Double > statModifier =  new LinkedHashMap<>();
        statModifier.put("Armor", this.rating);
        entity.modifyStats(statModifier);
    }

    public void unapplyRating(Entity entity){
        Map<String, Double> statModifier = new LinkedHashMap<>();
        statModifier.put("Armor", -this.rating);
        entity.modifyStats(statModifier);
    }

    protected abstract String getXmlTagName();

    @Override
    public Element generateXml(Document document) {
        Element element = document.createElement(getXmlTagName());
        element.setAttribute("rating", Double.toString(rating));
        element.setAttribute("name", name);
        element.setAttribute("id", Integer.toString(id));
        return element;
    }

    @Override
    public void initWithXmlElement(Element element) {
        this.rating = Double.valueOf(element.getAttribute("rating"));
        this.name = element.getAttribute("name");
        this.id = Integer.parseInt(element.getAttribute("id"));
    }

}