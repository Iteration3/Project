package Item;

import java.awt.image.BufferedImage;
import Location.Location;
import Entity.Entity;


/*
* Implemented by Peter Camejo
*/
public abstract class Item {
    /* Attributes */
    protected BufferedImage image;
    protected int id;
    protected Location location;
    protected String name;

    /* Constructors */
    protected Item(){
        this.image = null;
        this.id = -1;
        this.location = null;
        this.name = null;
    }
    protected Item(BufferedImage image, int id, Location location, String name){
        this.image = image;
        this.id = id;
        this.location = location;
        this.name = name;
    }

    /* Methods */
    public abstract void activate(Entity entity);

    //TODO: add gets/sets as needed.
    public int getId(){
        return this.id;
    }
    public BufferedImage getImage (){ return this.image;}

}