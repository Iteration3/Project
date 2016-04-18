package models.Occupation;

import models.SkillContainer.BasicSkillContainer;
import models.SkillContainer.SummonerSkillContainer;

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
    }
}
