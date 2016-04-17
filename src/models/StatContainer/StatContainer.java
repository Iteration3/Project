package models.StatContainer;

import models.Stat.Stat;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilities.SaveLoad.Saveable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class StatContainer implements Saveable {
    //
    protected double BASE_MODIFIER;
    protected Map<String, Double> OCCUPATION_MODIFIER;
    //
    protected Map<String, Stat> stats = new LinkedHashMap<>();

    // return Map containing all stats
    public Map<String, Stat> value() {return this.stats;}

    // return value of a specific stat
    public double value(String stat_to_get) {return value().get(stat_to_get).value();}
    public String name(String stat_to_get) {return value().get(stat_to_get).name();}

    /*
        use forEach() method of Map<> to iterate through the stats and call each
        member's modify() method
     */
    public void modifyStats(Map<String, Double> stat_to_modify) {
        stat_to_modify.forEach((k, v) -> value().get(k).modify(v));
        value().forEach((k, v)-> v.calculate());
    }

    /*
        use forEach() method of Map<> to iterate through the stats and call each
        member's print() method
    */
    public void print() {value().forEach((k, v) -> v.print());}

    // print a specific stat
    public void print(String stat_to_print) {value().get(stat_to_print).print();}

    //
    protected abstract void setStats(double base_modifier, Map<String, Double> occupation_modifier, int level);
    public abstract void levelUp();

    @Override
    public Element generateXml(Document document) {
        Element element = document.createElement("stats-container");
        element.setAttribute("baseModifier", Double.toString(BASE_MODIFIER));

        Element occupationModifier = document.createElement("occupation-modifier");
        for (String key : OCCUPATION_MODIFIER.keySet()) {
            Element modifier = document.createElement("modifier");
            modifier.setAttribute("key", key);
            modifier.setAttribute("value", OCCUPATION_MODIFIER.get(key).toString());
            occupationModifier.appendChild(modifier);
        }
        element.appendChild(occupationModifier);

        Element statsElement = document.createElement("stats");
        for (String key : stats.keySet())  {
            Element statElement = stats.get(key).generateXml(document);
            if (statElement != null) {
                statElement.setAttribute("key", key);
                statsElement.appendChild(statElement);
            }
        }
        element.appendChild(statsElement);
        return element;
    }

    public static StatContainer fromXmlElement(Element element) {
        Map<String, Double> occupationModifier = new HashMap<>();
        Element occupationModifierElement = (Element) element.getElementsByTagName("occupation-modifier").item(0);
        NodeList modifiers = occupationModifierElement.getElementsByTagName("modifier");
        for (int i = 0; i < modifiers.getLength(); ++i) {
            Element modifier = (Element) modifiers.item(i);
            occupationModifier.put(modifier.getAttribute("key"), Double.valueOf(modifier.getAttribute("value")));
        }
        StatContainer s = new AvatarStats(occupationModifier, 0);

        Element stats = (Element) element.getElementsByTagName("stats").item(0);
        NodeList statsList = stats.getElementsByTagName("stat");
        for (int i = 0; i < statsList.getLength(); ++i) {
            Element stat = (Element) statsList.item(i);
            Stat value = Stat.fromXmlElement(stat);
            s.stats.put(stat.getAttribute("key"), value);
        }
        return s;
    }
}
