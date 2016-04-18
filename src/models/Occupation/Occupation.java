package models.Occupation;

import models.Skill.Skill;
import models.SkillContainer.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utilities.SaveLoad.Saveable;
import utilities.SaveLoad.XmlReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Occupation implements Saveable {
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

    public Element generateDefaultXml(Document doc, String tagName) {
        Element element = doc.createElement(tagName);
        element.setAttribute("name", name);
        element.setAttribute("skillPoints", String.valueOf(skillPoints));

        Element basicSkills = doc.createElement("basic-skills");
        basicSkills.appendChild(basic_skills.generateXml(doc));
        Element specificSkills = doc.createElement("specific-skills");
        specificSkills.appendChild(specific_skills.generateXml(doc));
        Element activeSkills = doc.createElement("active-skills");
        activeSkills.appendChild(this.activeSkills.generateXml(doc));

        Element occupationModifier = doc.createElement("occupation-modifier");
        for (String key : occupation_modifier.keySet()) {
            Element modifier = doc.createElement("modifier");
            modifier.setAttribute("key", key);
            modifier.setAttribute("value", String.valueOf(occupation_modifier.get(key)));
            occupationModifier.appendChild(modifier);
        }
        element.appendChild(occupationModifier);

        element.appendChild(basicSkills);
        element.appendChild(specificSkills);
        element.appendChild(activeSkills);
        return element;
    }

    public static Occupation fromXmlElement(Element element) {
        final String tagName = element.getTagName();
        Occupation occupation = new Occupation() {
            @Override
            public Element generateXml(Document doc) {
                return super.generateDefaultXml(doc, tagName);
            }
        };

        Node basicSkillsContainer = element.getElementsByTagName("basic-skills").item(0);
        Element basicSkills = XmlReader.getFirstChildElement(basicSkillsContainer);
        occupation.basic_skills = SkillContainer.fromXmlElement(basicSkills);

        Node specificSkillsContainer = element.getElementsByTagName("specific-skills").item(0);
        Element specificSkills = XmlReader.getFirstChildElement(specificSkillsContainer);
        occupation.specific_skills = SkillContainer.fromXmlElement(specificSkills);

        Node activeSkillsContainer = element.getElementsByTagName("active-skills").item(0);
        Element activeSkills = XmlReader.getFirstChildElement(activeSkillsContainer);
        occupation.activeSkills = SkillContainer.fromXmlElement(activeSkills);

        Element occupationModifierContainer = (Element) element.getElementsByTagName("occupation-modifier").item(0);
        NodeList occupationModifiers = occupationModifierContainer.getElementsByTagName("modifier");
        for (int i = 0; i < occupationModifiers.getLength(); ++i) {
            Element modifier = (Element) occupationModifiers.item(i);
            occupation.occupation_modifier.put(modifier.getAttribute("key"), Double.valueOf(modifier.getAttribute("value")));
        }
        return occupation;
    }
}
