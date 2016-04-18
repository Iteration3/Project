package models.Skill.BasicSkill;
import models.Entity.Entity;
import models.Skill.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public abstract class BasicSkill extends Skill {

    protected String statAbv;

    public BasicSkill(String name, double manaCost, String abv) {
        super(name, manaCost, 0);
        statAbv = abv;
    }
    public abstract void activate(Entity entity);

    @Override
    protected void getAttributesFromXmlElement(Element element) {
        super.getAttributesFromXmlElement(element);
        statAbv = element.getAttribute("statAbv");
    }

    @Override
    public Element generateDefaultXml(Document document) {
        Element element = super.generateDefaultXml(document);
        element.setAttribute("statAbv", statAbv);
        return element;
    }
}
