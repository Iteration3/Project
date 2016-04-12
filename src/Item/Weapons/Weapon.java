package Item.Weapons;

import Item.EquipableItem;
import Inventory.Inventory;
import Equipment.Equipment;
import Item.Requirement;
import Location.Location;

import java.awt.image.BufferedImage;

/**
 *  Implemented by Peter Camejo
 */
public class Weapon extends EquipableItem {
    /* Attributes */
    protected Requirement requirement;
    protected double weaponSpeed;

    /* Constructor */
    public Weapon() {
        super();
        requirement = new Requirement();
    }

    public Weapon(double weaponSpeed, String requiredOccupation, BufferedImage image, int id, Location location, String name, double attackRating) {
        super(image, id, location, name, attackRating);
        requirement = new Requirement(null, 0, requiredOccupation);
        this.weaponSpeed = weaponSpeed;
    }

    public Weapon(double weaponSpeed, String requiredOccupation, int requiredLevel, BufferedImage image, int id, Location location, String name, double attackRating) {
        super(image, id, location, name, attackRating);
        requirement = new Requirement(null, requiredLevel, requiredOccupation);
        this.weaponSpeed = weaponSpeed;

    }

    /* Methods */
    public void equip(Equipment equipment, Inventory inventory) {
        equipment.setEquippedWeapon(this);
        inventory.removeItem(id);
    }

    public void unequip(Equipment equipment, Inventory inventory) {
        equipment.setEquippedWeapon(null);
        inventory.addItem(this);
    }

    ;

}