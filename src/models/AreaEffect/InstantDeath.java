package models.AreaEffect;

import models.Entity.Entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 4/14/2016.
 */
public class InstantDeath extends AreaEffect {

    public void execute(Entity e){
        killEntity(e);
    }

    private void  killEntity(Entity e){
        double a = e.statValue("Life");
        a = a*-1;
        Map statChange = new HashMap<>();
        statChange.put("Life",a);
        e.modifyStats(statChange);

    }
}
