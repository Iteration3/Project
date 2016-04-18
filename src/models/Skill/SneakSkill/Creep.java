package models.Skill.SneakSkill;
import models.Entity.*;
import models.Skill.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Creep extends SneakSkill {

    public Creep() {
        super("Creep", 5.0);
    }

    public void activate(Entity entity) {
        if (entity != null) {

        }
    }

    @Override
    protected String getXmlTagName() {
        return "creep";
    }

    @Override
    protected Skill cloneInitializedWithXmlElement(Element element) {
        Creep skill = new Creep();
        skill.getAttributesFromXmlElement(element);
        return skill;
    }

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc);
    }

    public void createSignal(models.Map.Map map, Entity entity) {

    }
}
