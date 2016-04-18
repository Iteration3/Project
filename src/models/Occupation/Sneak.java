package models.Occupation;

import models.SkillContainer.ActiveSkillContianer;
import models.SkillContainer.BasicSkillContainer;
import models.SkillContainer.SneakSkillContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Sneak extends Occupation {
    //
    public Sneak () {
        setName("Sneak");
        setOccupationModifier(1.50, 1.75, 1.25, 1.25);
        setSkillContainer();
        initSkillPoints();
    }
    //
    protected void setSkillContainer() {
        basic_skills = new BasicSkillContainer();
        specific_skills = new SneakSkillContainer();
        activeSkills = new ActiveSkillContianer(basic_skills, specific_skills);
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "sneak");
    }
}
