package models.Entity;


import models.Action.Action;
import models.Occupation.*;
import models.StatContainer.*;
import models.Item.*;

import java.util.Map;
import models.Inventory.*;
import models.Equipment.Equipment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Direction.Direction;
import utilities.Location.Location;
import utilities.SaveLoad.Saveable;

public abstract class Entity implements Action, Saveable {
    //
    protected String name;
    protected Location location;
    protected Direction direction;
    protected Occupation occupation;
    protected StatContainer stats;
    protected Inventory inventory;
    protected Equipment equipment;

    /*
        Methods used in constructors
     */
    //
    protected void setName(String name) {this.name = name;}
    protected void setLocation(Location location) {this.location = location;}
    protected void setDirection(Direction direction) {this.direction = direction;}
    protected void setOccupation(Occupation occupation) {this.occupation = occupation;}
    protected void setStats(StatContainer stats) {this.stats = stats;}
    protected void setInventory(Inventory inventory) {this.inventory = inventory;}
    //protected void setEquipment(models.Equipment equipment) {this.equipment = equipment);

    /*
        Action << interface >> implementation
     */
    //
    public void useSkill(Entity entity) {}
    public void useItem(Entity entity) {}
    public void attack() {}
    public void talk() {}

    /*
        models.Entity specific functionality
     */
    //
    public String name() {return this.name;}
    public void print() {
        System.out.println(name() + ": " + statName("LEVEL") + " " + (int)statValue("LEVEL") + " " + occupationName());
    }

    /*
        Location specific functionality
     */
    //
    public Location getLocation() {return this.location;}
    public void changeLocation(Location l) {setLocation(l);}        //added this for teleportation.
    //public void changeLocation() {this.getLocation.changeLocation();}


    /*
        models.Direction specific functionality
     */
    //
    public Direction direction() {return this.direction;}
    public void changeDirection(Direction direction) {this.direction = direction;}

    /*
        models.models.Occupation specific functionality
     */
    //
    public String occupationName() {return this.occupation.name();}
    protected Map<String, Double> occupationModifier() {return this.occupation.occupationModifier();}

    /*
        models.StatContainer specific functionality
     */
    //
    public void modifyStats(Map<String, Double> stat_to_modify) {this.stats.modifyStats(stat_to_modify);}
    public void levelUp() { this.stats.levelUp();}
    public double statValue(String stat_to_get) {return this.stats.value(stat_to_get);}
    public String statName(String stat_to_get) {return this.stats.name(stat_to_get);}
    public void printStats(String stat_to_print) {this.stats.print(stat_to_print);}
    public void printStats() {this.stats.print();}
    public double getLevel(){ return this.stats.value("LEVEL");}

    /*
        models.Equipment specific functionality
     */
    //
    public void equip(EquipableItem item) {
 //       item.equip(equipment , inventory);
        item.applyRating(this);
    }
    public void unequip(EquipableItem item) {
 //       item.unequip(equipment , inventory);
        item.unapplyRating(this);
    }

    public Equipment getEquipment(){
        return this.equipment;
    }

    /*
        models.Inventory specific functionality
     */
    //
    public void addItem(TakeableItem item) {
        inventory.addItem(item);
    }
    public void moveItem(Item item) {}
    public void dropItem(Item item) {
        inventory.removeItem(item.getId());
        //Place item on tile at this getLocation.
    }
    public void destroyItem(int id){
        inventory.removeItem(id);
    }
    public void useItem(TakeableItem item){
        item.use(this);
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    protected Element generateXml(Document document, String tagName) {
        Element element = document.createElement(tagName);

        element.setAttribute("name", name);
        element.setAttribute("level", String.valueOf(getLevel()));
        element.appendChild(location.generateXml(document));
        element.appendChild(direction.generateXml(document));
        element.appendChild(occupation.generateXml(document));
        element.appendChild(stats.generateXml(document));
        element.appendChild(inventory.generateXml(document));
        element.appendChild(equipment.generateXml(document));
        return element;
    }

    public static Entity fromXmlElement(Element element) {
        Entity entity = null;
        int level = Integer.parseInt(element.getAttribute("level"));
        Occupation occupation = Occupation.fromXmlElement((Element) element.getElementsByTagName("occupation").item(0));

        switch (element.getTagName()) {
            case "avatar": entity = new Avatar(level, occupation); break;
            case "mount": entity = new Mount(level, occupation); break;
            case "npc": entity = new NPC(level, occupation); break;
            case "pet": entity = new Pet(level, occupation); break;
            case "entity-for-test": entity = new EnittyForTesting(); break;
        }
        entity.setLocation(Location.fromXmlElement((Element) element.getElementsByTagName("location").item(0)));
        entity.setDirection(Direction.fromXmlElement((Element) element.getElementsByTagName("direction").item(0)));
        entity.setStats(StatContainer.fromXmlElement((Element) element.getElementsByTagName("stats-container").item(0)));
        entity.setInventory(Inventory.fromXmlElement((Element) element.getElementsByTagName("inventory").item(0)));
        entity.equipment = Equipment.fromXmlElement((Element) element.getElementsByTagName("equipment").item(0));
        return entity;
    }
}
