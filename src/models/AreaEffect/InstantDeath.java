package models.AreaEffect;

import models.Entity.Entity;
import utilities.Location.Location;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class InstantDeath extends AreaEffect {

    public InstantDeath(Location l){
        loc = l;
    }

    public void execute(Entity e){
        killEntity(e);
    }

    private void  killEntity(Entity e) {
        //double a = e.statValue("Life");
        //a = a*-1;
        Map<String, Double> statChange = new HashMap<>();
        statChange.put("LIVES", -1.0);
        e.modifyStats(statChange);
    }

    public Image getImage(){
        Image image = new ImageIcon("res/circle-dash.png").getImage();
        return image;
    }
}
