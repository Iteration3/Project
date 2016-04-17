package utilities.SaveLoad;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public interface Saveable {

    public Element generateXml(Document doc);

}
