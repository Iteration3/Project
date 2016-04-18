package models.Skill.SmasherSkill;

import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OneHandedWeapon extends SmasherSkill {

    public OneHandedWeapon() {
        super("One Handed Weapon", 1, 2);
    }

    @Override
    protected String getXmlTagName() {
        return "one-handed-weapon";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        OneHandedWeapon weapon = new OneHandedWeapon();
        weapon.getAttributesFromXmlElement(element);
        return weapon;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }
}
