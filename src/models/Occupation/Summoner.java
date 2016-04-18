package models.Occupation;

import models.SkillContainer.ActiveSkillContianer;
import models.SkillContainer.BasicSkillContainer;
import models.SkillContainer.SummonerSkillContainer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Summoner extends Occupation {
    //
    public Summoner () {
        setName("Summoner");
        setOccupationModifier(1.0, 1.25, 2.5, 1.0);
        setSkillContainer();
        initSkillPoints();
    }
    //
    protected void setSkillContainer() {
        basic_skills = new BasicSkillContainer();
        specific_skills = new SummonerSkillContainer();
        activeSkills = new ActiveSkillContianer(basic_skills, specific_skills);
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "summoner");
    }
}
