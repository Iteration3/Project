package models.SkillContainer;
import models.Skill.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilities.SaveLoad.Saveable;

import javax.xml.soap.Node;
import java.util.ArrayList;


public abstract class SkillContainer implements Saveable {

    protected ArrayList<Skill> listOfSkills;
    protected ArrayList<Skill> listOfSkillsNotAdded;

    public SkillContainer() {
        listOfSkills = new ArrayList<>();
        listOfSkillsNotAdded = new ArrayList<>();
    }

    protected void addSkillToList(Skill skill) {
        listOfSkills.add(skill);
    }

    protected void addSkillToListNotAdded(Skill skill) {
        listOfSkillsNotAdded.add(skill);
    }

    public void addSkill(Skill skill) {
        if (listOfSkillsNotAdded.contains(skill)) {
            int indexOfSkill = listOfSkillsNotAdded.indexOf(skill);
            listOfSkillsNotAdded.remove(indexOfSkill);
            listOfSkills.add(skill);
        }
    }

    public void setSkillDeactivated(Skill skill) {
        listOfSkills.remove(skill);
    }

    public void setSkillActive(Skill skill) {
        listOfSkills.add(skill);
    }

    public ArrayList<Skill> getListOfSkills() {
        return listOfSkills;
    }

    @Override
    public Element generateXml(Document document) {
        Element element = document.createElement("skill-container");

        Element skills = document.createElement("skills");
        Element notAddedSkills = document.createElement("skills-not-added");

        for (Skill skill : listOfSkills) {
            skills.appendChild(skill.generateXml(document));
        }
        for (Skill skill : listOfSkillsNotAdded) {
            notAddedSkills.appendChild(skill.generateXml(document));
        }

        element.appendChild(skills);
        element.appendChild(notAddedSkills);

        return element;
    }

    public static SkillContainer fromXmlElement(Element element) {
        SkillContainer container =  new SkillContainer() { };
        NodeList skillsList = element.getElementsByTagName("skills").item(0).getChildNodes();
        for (int i = 0; i < skillsList.getLength(); ++i) {
            if (skillsList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element s = (Element) skillsList.item(i);
                container.listOfSkills.add(SkillParser.getSkillFromXmlElement(s));
            }
        }
        NodeList skillsNotAddedList = element.getElementsByTagName("skills-not-added").item(0).getChildNodes();
        for (int i = 0; i < skillsNotAddedList.getLength(); ++i) {
            if (skillsList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element s = (Element) skillsList.item(i);
                container.listOfSkillsNotAdded.add(SkillParser.getSkillFromXmlElement(s));
            }
        }
        return container;
    }

    public Skill getSkill(int n) {
        return listOfSkills.get(n);
    }

}
