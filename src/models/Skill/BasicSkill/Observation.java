package models.Skill.BasicSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;


public class Observation extends BasicSkill {
    public Observation() {
        super("Observation", 5, "obv");
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> observationAmountMap = getObservationAmountMap();
            entity.modifyStats(observationAmountMap);
        }
    }

    public Map<String, Double> getObservationAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount(5);
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount(int distance) {
        double amount = 0;
        double random = Math.random() * 100;
        if (random < level * 20) {
            amount = Math.random() * 20;
        }
        else {
            amount = Math.random() * 30 + 20;
        }
        return calculatorMultiplier * amount * distance * 0.5;
    }

    @Override
    protected String getXmlTagName() {
        return "observation";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Observation weapon = new Observation();
        weapon.getAttributesFromXmlElement(element);
        return weapon;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
