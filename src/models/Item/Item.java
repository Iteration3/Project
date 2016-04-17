package models.Item;

import java.awt.image.BufferedImage;
import models.Entity.Entity;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;


/*
* Implemented by Peter Camejo
*/
public abstract class Item implements Saveable {
    /* Attributes */
    protected BufferedImage image;
    protected int id;
    protected String name;

    /* Constructors */
    protected Item(){
        this.image = null;
        this.id = -1;
        this.name = null;
    }
    protected Item(BufferedImage image, int id, String name){
        this.image = image;
        this.id = id;
        this.name = name;
    }

    /* Methods */
    public abstract void activate(Entity entity);

    //TODO: add gets/sets as needed.
    public int getId(){
        return this.id;
    }
    public BufferedImage getImage (){ return this.image;}
    public String getName(){ return this.name;}

    /**
     * @return a distinct copy of this item
     */
    public abstract Item clone();

    /**
     * initialize this item with an xml element. used in itemfactory when loading a game from an xml file
     */
    public abstract void initWithXmlElement(Element element);
}