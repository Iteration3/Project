package models.Equipment;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import models.ArmorContainer.ArmorContainer;
import models.Item.Armors.*;
import models.Item.Item;
import models.Item.ItemFactory;
import models.Item.Weapons.Weapon;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utilities.SaveLoad.Saveable;


/**
 *  Implemented by Peter Camejo
 */
public class Equipment implements ArmorContainer, Saveable {
    /* Attributes */
    protected Armor[] armor;
    protected Weapon equippedWeapon;

    /* Constructors */
    public Equipment(){
        armor = new Armor[MAX_CONTAINER_SIZE];
        equippedWeapon = null;
        init();
    }

    /* Methods */
    public void init(){
        for(int i = 0 ; i < MAX_CONTAINER_SIZE ; i++){
            armor[i] = null;
        }
    }

    /*******************  HEAD  ************************/
    public void addHead(HeadArmor headArmor){
        if(armor[HEAD_SLOT] != null){
            System.out.println(" Equip Failed: Head slot is full");
            return;
        }

        armor[HEAD_SLOT] = headArmor;
    }

    public HeadArmor removeHead(){
        HeadArmor tempArmor = (HeadArmor) armor[HEAD_SLOT];
        armor[HEAD_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasHead(){
        if(armor[HEAD_SLOT] == null){
            return false;
        }
        return true;
    }

    public HeadArmor getHead(){
        return (HeadArmor) armor[HEAD_SLOT];
    }

    /******************** CHEST ***********************/
    public void addChest(ChestArmor chestArmor){
        if(armor[CHEST_SLOT] != null){
            System.out.println("Equip failed : Chest slot is full");
            return;
        }

        armor[CHEST_SLOT] = chestArmor;
    }

    public ChestArmor removeChest(){
        ChestArmor tempArmor = (ChestArmor) armor[CHEST_SLOT];
        armor[CHEST_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasChest(){
        if(armor[CHEST_SLOT] == null){
            return false;
        }
        return true;
    }

    public ChestArmor getChest(){
        return (ChestArmor) armor[CHEST_SLOT];

    }

    /***************** LEGS ************************/
    public void addLegs(LegArmor legArmor){
        if(armor[LEG_SLOT] != null) {
            System.out.println("Equip Failed : Leg slot is full");
            return;
        }
        armor[LEG_SLOT] = legArmor;
    }

    public LegArmor removeLegs(){
        LegArmor tempArmor = (LegArmor) armor[LEG_SLOT];
        armor[LEG_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasLegs(){
        if(armor[LEG_SLOT] == null){
            return false;
        }
        return true;
    }

    public LegArmor getLegs(){
        return (LegArmor) armor[LEG_SLOT];
    }

    /*************** GLOVES **************/
    public void addGloves(GloveArmor gloveArmor){
        if(armor[GLOVE_SLOT] != null){
            System.out.println("Equip Failed: Glove slot is full.");
            return;
        }

        armor[GLOVE_SLOT] = gloveArmor;
    }

    public GloveArmor removeGloves(){
        GloveArmor tempArmor = (GloveArmor) armor[GLOVE_SLOT];
        armor[GLOVE_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasGloves(){
        if(armor[GLOVE_SLOT] == null){
            return false;
        }
        return true;
    }

    public GloveArmor getGloves(){
        return (GloveArmor)armor[GLOVE_SLOT];
    }

    /**************** BOOTS ***************/
    public void addBoots(BootArmor bootArmor){
        if(armor[BOOT_SLOT] != null){
            System.out.println("Equip Failed: Boot slot is full.");
            return;
        }

        armor[BOOT_SLOT] = bootArmor;
    }

    public BootArmor removeBoots(){
        BootArmor tempArmor = (BootArmor) armor[BOOT_SLOT];
        armor[BOOT_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasBoots(){
        if(armor[BOOT_SLOT] == null){
            return false;
        }

        return true;
    }

    public BootArmor getBoots(){
        return (BootArmor) armor[BOOT_SLOT];
    }

    /***************** TRINKET ********************/
    public void addTrinket(Trinket trinket){
        if(armor[TRINKET_SLOT] != null){
            System.out.println("Equip failed: Trinket Slot full");
            return;
        }

        armor[TRINKET_SLOT] = trinket;
    }

    public Trinket removeTrinket(){
        Trinket tempArmor = (Trinket) armor[TRINKET_SLOT];
        armor[TRINKET_SLOT] = null;
        return tempArmor;
    }

    public Boolean hasTrinket(){
        if(armor[TRINKET_SLOT] == null){
            return false;
        }
        return true;
    }

    public Trinket getTrinket(){
        return (Trinket) armor[TRINKET_SLOT];
    }

    /****************** WEAPON **************/
    public Weapon getWeapon(){
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(Weapon weapon){
        this.equippedWeapon = weapon;
        return;
    }

    public Element generateXml(Document document) {
        Element e = document.createElement("equipment");
        Element armor = document.createElement("armor");
        e.appendChild(armor);
        for (Armor a : this.armor) {
            if (a != null) {
                armor.appendChild(a.generateXml(document));
            } else {
                armor.appendChild(document.createElement("null-armor"));
            }
        }
        Element weapon = document.createElement("weapon");
        if (equippedWeapon != null) {
            weapon.appendChild(equippedWeapon.generateXml(document));
        }
        e.appendChild(weapon);
        return e;
    }

    public static Equipment fromXmlElement(Element element) {

        Equipment equipment = new Equipment();

        Element armorElement = (Element) element.getElementsByTagName("armor").item(0);
        NodeList armorList = armorElement.getChildNodes();
        for (int i = 0; i < armorList.getLength(); ++i) {
            Element e = (Element) armorList.item(i);
            if (element.getTagName().equals("null-armor")) {
                equipment.armor[i] = null;
            } else {
                Item item = ItemFactory.fromXmlElement(e);
                equipment.armor[i] = (Armor) item;
            }
        }
        NodeList weaponList = element.getElementsByTagName("weapon");
        if (weaponList.getLength() > 0) {
            Element weapon = (Element) weaponList.item(0).getFirstChild();
            equipment.equippedWeapon = (Weapon) ItemFactory.fromXmlElement(weapon);
        }
        return equipment;

    }
}
