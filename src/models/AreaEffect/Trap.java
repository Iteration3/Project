package models.AreaEffect;

import models.Entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.Location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andy on 4/14/2016.
 */
public class Trap extends AreaEffect {

    private boolean active;
    private Timer timer = new Timer();
    public Trap(Location l){
        loc = l;
        active = true;
    }
    public void execute(Entity e){
        trap(e);
    }

    private void trap(Entity e){
        if(active) {
            //double previous = e.statValue("Movement");

            Map statChange = new HashMap<>();
            Map statChange2 = new HashMap<>();
            statChange.put("Movement", -100);
            statChange2.put("Movement",100);
            e.modifyStats(statChange);

            forceToWait();              //this should cause it to wait 5 seconds before executing this
            e.modifyStats(statChange2);
        }

        //disable();
    }

    public synchronized void forceToWait() {
        this.timer.cancel(); //this will cancel the current task. if there is no active task, nothing happens
        this.timer = new Timer();

        TimerTask action = new TimerTask() {
            public void run() {
                disable(); //as you said in the comments: abc is a static method
            }

        };

        this.timer.schedule(action, 5000); //this starts the task
    }

    private void disable() {
        active = false;
    }

    @Override
    public Element generateXml(Document doc) {
        Element element =  super.generateDefaultXml(doc, "trap-area-effect");
        element.setAttribute("active", Boolean.toString(active));
        return element;
    }

    @Override
    protected AreaEffect clone() {
        Trap trap = new Trap(this.loc);
        trap.active = this.active;
        return trap;
    }

    @Override
    protected void initWithXml(Element element) {
        Element locationElement = (Element) element.getElementsByTagName("location").item(0);
        loc = Location.fromXmlElement(locationElement);
        active = Boolean.parseBoolean(element.getAttribute("active"));
    }
}
