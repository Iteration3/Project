package models.Skill.SmasherSkill;

import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Brawling extends SmasherSkill {

    public Brawling() {
        super("Brawling", 1, 1);
    }

    @Override
    protected String getXmlTagName() {
        return "brawling";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Brawling weapon = new Brawling();
        weapon.getAttributesFromXmlElement(element);
        return weapon;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
