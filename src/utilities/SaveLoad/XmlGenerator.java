package utilities.SaveLoad;


import models.Map.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.stream.Stream;

public class XmlGenerator {

    public String generateXml(Map map) throws ParserConfigurationException {
        return xmlDocumentToString(generateXmlDocument(map));
    }

    private Document generateXmlDocument(Map map) throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element element = map.generateXml(doc);
        doc.appendChild(element);
        return doc;
    }

    private void writeXmlToStream(Document doc, Writer writer) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(writer);

            //Formats it nicely (5 is the max number of child nodes
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformerFactory.setAttribute("indent-number", 5);
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount",
                    Integer.toString(4));
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private String xmlDocumentToString(Document doc) {
        StringWriter writer = new StringWriter();
        writeXmlToStream(doc, writer);
        return writer.getBuffer().toString();
    }

    public void saveMapToFile(String fileName, Map map) throws IOException, ParserConfigurationException {
        FileWriter writer = new FileWriter(fileName);
        Document doc = generateXmlDocument(map);
        writeXmlToStream(doc, writer);
    }
}
