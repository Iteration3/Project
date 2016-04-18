package models.Occupation;

import models.SkillContainer.ActiveSkillContianer;
import models.SkillContainer.BasicSkillContainer;
import models.SkillContainer.SmasherSkillContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Smasher extends Occupation {
    //
    public Smasher () {
        setName("Smasher");
        setOccupationModifier(1.75, 1.50, 0.75, 1.75);
        setSkillContainer();
        initSkillPoints();
    }
    //
    protected void setSkillContainer() {
        basic_skills = new BasicSkillContainer();
        specific_skills = new SmasherSkillContainer();
        activeSkills = new ActiveSkillContianer(basic_skills, specific_skills);
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "smasher");
    }
}
