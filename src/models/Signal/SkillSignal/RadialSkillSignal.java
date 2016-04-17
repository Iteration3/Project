package models.Signal.SkillSignal;

import models.Decal.Decal;
import models.Decal.FireBallDecal;
import models.Entity.Entity;
import models.Map.Map;
import models.Skill.Skill;
import utilities.Direction.Direction;
import utilities.Location.Location;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class RadialSkillSignal extends SkillSignal {

    Direction dir;

    public RadialSkillSignal(Map map, Entity avatar, Skill skill) {
        super(map, avatar, skill);
        dir = avatar.getDirection();
    }


    protected void useSkill(Skill skill) {

        Decal decal = new FireBallDecal();

        //if (skill.canUseSkill(avatar)) {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            ArrayList<Location> nextLocation = new ArrayList<Location>();
            public void run() {



                for (int i = 0; i < nextLocation.size(); ++i) {
                    map.getTileAt(nextLocation.get(i)).removeDecal();
                }


                if (currentRadius == 0) {
                    nextLocation = getLocationArray(1);
                }
                if (currentRadius == 1) {
                    nextLocation = getLocationArray2(nextLocation);
                }

                for (int i = 0; i < nextLocation.size(); ++i) {
                    System.out.println(nextLocation.get(i));
                    map.getTileAt(nextLocation.get(i)).addDecal(decal);
                }
                // Entity entityToAttack = map.getTileAt(nextLocation).getEntity();

                //skill.activate(entityToAttack);
                System.out.println("FIREBALL");
                //avatarLocation = nextLocation.get(1);

                currentRadius++;
                if (currentRadius == 3) {
                    for (int i = 0; i < nextLocation.size(); ++i) {
                        map.getTileAt(nextLocation.get(i)).removeDecal();
                    }
                    t.cancel();
                }

            }
        }, 0, 1000);
        // }
    }

    private ArrayList<Location> getLocationArray(int n){
        ArrayList<Location> list = new ArrayList<>();
        Direction nextDirection = dir;
        if (n == 1) {
            list.add(nextDirection.getNextLocation(avatarLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            list.add(nextDirection.getNextLocation(avatarLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            list.add(nextDirection.getNextLocation(avatarLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            list.add(nextDirection.getNextLocation(avatarLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            list.add(nextDirection.getNextLocation(avatarLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            list.add(nextDirection.getNextLocation(avatarLocation));
        }

        return list;
    }

    private ArrayList<Location> getLocationArray2(ArrayList<Location> list){
        ArrayList<Location> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); ++i) {
            Direction nextDirection = dir;
            Location currentLocation = list.get(i);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
            nextDirection = nextDirection.clockwise(nextDirection);
            newList.add(nextDirection.getNextLocation(currentLocation));
        }

        for (int i = newList.size() - 1; i > -1; --i) {
            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j).equals(newList.get(i))) {
                    newList.remove(i);
                    j = list.size();
                }
            }
        }
        return newList;
    }


}
