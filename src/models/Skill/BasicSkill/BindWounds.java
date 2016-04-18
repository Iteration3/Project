package models.Skill.BasicSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import models.Signal.SkillSignal.SelfSkillSignal;

import java.util.HashMap;
import java.util.Map;


public class BindWounds extends BasicSkill {

    public BindWounds() {
        super("Bind Wounds", 5, "CURRENT_LIFE");
    }

    public void activate(Entity entity) {
        if (entity != null ) {
            Map<String, Double> healAmountMap = getHealAmountMap();
            entity.modifyStats(healAmountMap);
        }
    }

    @Override
    protected String getXmlTagName() {
        return "bind-wounds";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        BindWounds skill = new BindWounds();
        skill.getAttributesFromXmlElement(element);
        return skill;
    }

    public Map<String, Double> getHealAmountMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyByAmount = getModifyAmount();
        map.put(statAbv, modifyByAmount);
        return map;
    }

    public void createSignal(models.Map.Map map, Entity entity) {
        new SelfSkillSignal(map, entity, this);
    }

    protected double getModifyAmount() {
        return calculatorMultiplier * level * 10;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
