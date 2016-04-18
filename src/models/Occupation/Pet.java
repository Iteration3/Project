package models.Occupation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Pet extends Occupation {
    //
    public Pet () {
        setName("Pet");
        setOccupationModifier(1.5, 1.0, 1.0, 2.0);
        setSkillContainer();
    }
    //
    protected void setSkillContainer() {}

    @Override
    public Element generateXml(Document doc) {
        return super.generateDefaultXml(doc, "pet");
    }
}
