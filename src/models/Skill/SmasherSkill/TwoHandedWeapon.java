package models.Skill.SmasherSkill;

import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TwoHandedWeapon extends SmasherSkill {

    public TwoHandedWeapon() {
        super("Two Handed Weapon", 1, 3);
    }

    @Override
    protected String getXmlTagName() {
        return "two-handed-weapon";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        TwoHandedWeapon weapon = new TwoHandedWeapon();
        weapon.getAttributesFromXmlElement(element);
        return weapon;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
