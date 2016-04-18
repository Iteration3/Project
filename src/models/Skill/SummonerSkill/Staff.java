package models.Skill.SummonerSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;


public class Staff extends SummonerSkill {

    public Staff() {
        super("Staff", 0, 1);
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> damageAmountMap = getDamageAmountMap();
            entity.modifyStats(damageAmountMap);
        }
    }

    @Override
    protected String getXmlTagName() {
        return "staff";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Staff staff = new Staff();
        staff.getAttributesFromXmlElement(element);
        return staff;
    }

    public Map<String, Double> getDamageAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyAmount = getModifyAmount();
        map.put("CURRENT_LIFE", -modifyAmount);
        return map;
    }

    private double getModifyAmount() {
        return level * 3 * calculatorMultiplier;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
