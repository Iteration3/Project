package models.Stat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;

public abstract class Stat implements Saveable {
    //
    protected String name;
    protected double value;
    //
    protected void setName(String name) {this.name = name;}
    protected void setValue(double value) {this.value = value;}
    //
    public String name() {return this.name;}
    public double value() {return this.value;}
    public void print() {System.out.printf(name() + ": %.2f\n", value());}
    public abstract void scale(double amt);
    public abstract void modify(double amt);
    public abstract void calculate();

    public Element generateXml(Document document) {
        Element element = document.createElement("stat");
        element.setAttribute("name", name);
        element.setTextContent(Double.toString(value));
        return element;
    }
}
