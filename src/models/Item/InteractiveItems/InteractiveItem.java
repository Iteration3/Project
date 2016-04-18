package models.Item.InteractiveItems;



/*
* Implemented by Peter Camejo
*/

import models.Entity.Entity;
import models.Item.Item;
import models.Item.Requirement;
import models.Item.TakeableItem;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;

import java.awt.image.BufferedImage;

abstract class InteractiveItem extends Item implements Saveable {


    /* Attributes */
    protected Requirement requirement;

    /* Constructors */
    public InteractiveItem(){
        requirement = new Requirement();
    }

    public InteractiveItem(BufferedImage image, int id, String name , TakeableItem requiredItem){
        super(image, id, name);
        requirement = new Requirement(requiredItem , 0 , null);
    }

    /* Methods */
    public abstract void passReqActivation(Entity entity);

    public void activate(Entity entity){
        if(requirement.meetsRequirements(entity) == false){
            System.out.println("Activation Failed : You do not have the required item " + requirement.getRequiredItemName());
            return; //do nothing
        }

        passReqActivation(entity);
    }

    protected Element generateDefaultXml(Document doc, String tagName) {
        Element element = doc.createElement(tagName);
        element.appendChild(requirement.generateXml(doc));
        element.setAttribute("name", name);
        element.setAttribute("id", Integer.toString(id));
        return element;
    }
}
