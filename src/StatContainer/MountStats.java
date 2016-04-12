package StatContainer;

import Stat.*;

import java.util.Map;
import java.util.HashMap;

public class MountStats extends StatContainer {
    //
    public MountStats() {
        setStats(3.0, new HashMap<>(), 1);
    }

    //
    protected void setStats(double base_modifier, Map<String, Double> occupation_modifier, int level) {
        //
        this.stats.put("MOVEMENT", new Movement(2.0));
    }
    //
    public void levelUp() {}
}
