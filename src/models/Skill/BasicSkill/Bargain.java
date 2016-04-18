package models.Skill.BasicSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;


public class Bargain extends BasicSkill {

    public Bargain() {
        super("Bargain", 5, "BARGAIN");
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> bagainSkillAmountMapModifier = getBargainSkillAmountMap();
            entity.modifyStats(bagainSkillAmountMapModifier);
        }
    }

    @Override
    protected String getXmlTagName() {
        return "bargain";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Bargain skill = new Bargain();
        skill.getAttributesFromXmlElement(element);
        return skill;
    }

    public Map<String, Double> getBargainSkillAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
