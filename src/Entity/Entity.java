package Entity;

import Action.Action;
import Location.Location;
import Direction.Direction;
import Occupation.*;
import StatContainer.*;
import Item.*;

import java.util.Map;
import Inventory.*;

public abstract class Entity implements Action {
    //
    protected String name;
    protected Location location;
    protected Direction direction;
    protected Occupation occupation;
    protected StatContainer stats;
    protected Inventory inventory;
    //protected Equipment equipment;

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
    //protected void setEquipment(Equipment equipment) {this.equipment = equipment);

    /*
        Action << interface >> implementation
     */
    //
    public void useSkill(Entity entity) {}
    public void useItem(Entity entity) {}
    public void attack() {}
    public void talk() {}

    /*
        Entity specific functionality
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
    public Location location() {return this.location;}
    //public void changeLocation() {this.location.changeLocation();}

    /*
        Direction specific functionality
     */
    //
    public Direction direction() {return this.direction;}
    public void changeDirection(Direction direction) {this.direction = direction;}

    /*
        Occupation specific functionality
     */
    //
    public String occupationName() {return this.occupation.name();}
    protected Map<String, Double> occupationModifier() {return this.occupation.occupationModifier();}

    /*
        StatContainer specific functionality
     */
    //
    public void modifyStats(Map<String, Double> stat_to_modify) {this.stats.modifyStats(stat_to_modify);}
    public void levelUp() {this.stats.levelUp();}
    public double statValue(String stat_to_get) {return this.stats.value(stat_to_get);}
    public String statName(String stat_to_get) {return this.stats.name(stat_to_get);}
    public void printStats(String stat_to_print) {this.stats.print(stat_to_print);}
    public void printStats() {this.stats.print();}

    /*
        Equipment specific functionality
     */
    //
    //public void equip(Equippable item_to_equip) {}
    //public void unequip(Equippable item_to_unequip) {}

    /*
        Inventory specific functionality
     */
    //
    public void addItem(Item item) {}
    public void moveItem(Item item) {}
    public void dropItem(Item item) {}
}
