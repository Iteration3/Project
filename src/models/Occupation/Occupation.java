package models.Occupation;

import models.Skill.Skill;
import models.SkillContainer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Occupation {
    //
    protected String name;
    protected SkillContainer basic_skills;
    protected SkillContainer specific_skills;
    protected SkillContainer activeSkills;

    protected Map<String, Double> occupation_modifier = new HashMap<>();
    protected int skillPoints;

    //
    protected void setName(String name) {this.name = name;}
    //
    protected void setSkillContainer(SkillContainer basic, SkillContainer specific) {
        this.basic_skills = basic;
        this.specific_skills = specific;
    };
    //
    protected void setOccupationModifier(double strength, double agility, double intellect, double hardiness) {
        //
        this.occupation_modifier.put("STRENGTH", strength);
        this.occupation_modifier.put("AGILITY", agility);
        this.occupation_modifier.put("INTELLECT", intellect);
        this.occupation_modifier.put("HARDINESS", hardiness);
    }
    //
    public String name() {return this.name;}
    /*
        occupationModifier() returns a Map that is used as a parameter for the models.StatContainer.
        occupationModifier() is used to modify the primary stats (and, by extension, the
        secondary stats).
     */
    //
    public Map<String, Double> occupationModifier() {return this.occupation_modifier;}

    public ArrayList<Skill> getBasicSkill() {
        return basic_skills.getListOfSkills();
    }

    public ArrayList<Skill> getSpecificSkills() {
        return specific_skills.getListOfSkills();
    }

    public ArrayList<Skill> getActiveSkills() {
        return activeSkills.getListOfSkills();
    }

    public Skill getActiveSkill(int n) {
        return activeSkills.getSkill(n);
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void useSkillPoint() {
        skillPoints--;
    }

    public void addSkillPoints() {
        skillPoints = skillPoints + 5;
    }

    protected void initSkillPoints() {
        skillPoints = 20;
    }

    public void replaceActiveSkill(Skill oldSkill, Skill newSkill) {
        activeSkills.setSkillDeactivated(oldSkill);
        activeSkills.setSkillActive(newSkill);
    }
}
