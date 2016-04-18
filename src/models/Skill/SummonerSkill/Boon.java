package models.Skill.SummonerSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Map;


public class Boon extends SummonerSkill {

    public Boon() {
        super("Boon", 15, 0);
    }

    public void activate(Entity entity) {
        if (entity != null) {
            Map<String, Double> statsBuffMap = getStatsBuffMap();
            entity.modifyStats(statsBuffMap);
        }
    }

    @Override
    protected String getXmlTagName() {
        return "boon";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Boon boon = new Boon();
        boon.getAttributesFromXmlElement(element);
        return boon;
    }

    public Map<String, Double> getStatsBuffMap() {
        Map<String, Double> map = new HashMap<>();
        double modifyAmountArray[] = getModifyAmount();
        map.put("INTELLECT", modifyAmountArray[0]);
        map.put("HARDINESS", modifyAmountArray[1]);
        map.put("MOVEMENT", modifyAmountArray[2]);
        return map;
    }

    private double[] getModifyAmount() {
        double modifyAmountArray[] = new double[3];
        //partial immunities?
        modifyAmountArray[0] = 10 * level;
        modifyAmountArray[1] = 20 * level;
        modifyAmountArray[2] = 2 * level;
        return modifyAmountArray;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
