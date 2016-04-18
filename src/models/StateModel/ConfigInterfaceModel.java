package models.StateModel;

import models.Entity.Entity;
import models.Stat.Stat;
import models.StatContainer.StatContainer;
import utilities.State.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ConfigInterfaceModel{


    private int currentPoint;
    private int size;

    public ConfigInterfaceModel(){
        currentPoint = 0;
        size = 10;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }

    public int getSize() {
        return size;
    }

    public void up() {
        currentPoint++;
    }

    public void down() {
        currentPoint--;
    }
}
