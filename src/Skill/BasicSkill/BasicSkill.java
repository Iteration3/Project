package Skill.BasicSkill;
import Skill.*;


public class BasicSkill extends Skill {

    protected String statAbv;

    public BasicSkill(String name, double manaCost, String abv) {
        super(name, manaCost);
        statAbv = abv;
    }

}
