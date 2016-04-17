package models.Item;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilities.Location.Location;

/*
* Implemented by Peter Camejo
*/

public class ConsumableItem extends TakeableItem {
    /* Attributes */
    private Map<String , Double> statModifier;

    /* Constructor */
    public ConsumableItem(){
        super();
    }


    public ConsumableItem(String statName , double modifier , BufferedImage image , int id, String name){
        super(image, id, name);
        statModifier = new LinkedHashMap<>();
        statModifier.put(statName , modifier);
    }

    /* Methods */
    public void use(Entity entity){
        entity.modifyStats(this.statModifier);
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("consumable-item");
        element.setAttribute("name", name);
        element.setAttribute("id", String.valueOf(id));
        for (String key : statModifier.keySet()) {
            Element stat = doc.createElement("stat");
            stat.setAttribute("key", key);
            stat.setAttribute("modifier", statModifier.get(key).toString());
            element.appendChild(stat);
        }
        return element;
    }

    @Override
    public Item clone() {
        return new ConsumableItem("", 0, image, id, name);
    }

    @Override
    public void initWithXmlElement(Element element) {
        Map<String, Double> statModifier = new HashMap<>();
        NodeList statList = element.getElementsByTagName("stat");
        for (int i = 0; i < statList.getLength(); ++i) {
            Element e = (Element) statList.item(i);
            statModifier.put(e.getAttribute("key"), Double.valueOf(e.getAttribute("modifier")));
        }
        this.statModifier = statModifier;
        name = element.getAttribute("name");
        id = Integer.parseInt(element.getAttribute("id"));
    }
}