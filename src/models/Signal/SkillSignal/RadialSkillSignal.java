package models.Signal.SkillSignal;

import models.Decal.Decal;
import models.Decal.FireBallDecal;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Location.Location;

import java.util.Timer;
import java.util.TimerTask;


public class RadialSkillSignal extends SkillSignal {


    public RadialSkillSignal(Map map) {
        //super(map, avatar, skill);
        super(map, null);
    }

    protected void useSkill(Skill skill) {
        Decal decal = new FireBallDecal();

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                currentRadius++;

                map.getTileAt(avatarLocation).removeDecal();
                Location nextLocation = new Location(currentRadius,0,0);




                map.getTileAt(nextLocation).addDecal(decal);
                System.out.println("TESTTESTTEST");
                avatarLocation = nextLocation;

                if (currentRadius == radius) {
                    map.getTileAt(avatarLocation).removeDecal();
                    t.cancel();
                }
            }
        }, 0, 1000);
    }

}
