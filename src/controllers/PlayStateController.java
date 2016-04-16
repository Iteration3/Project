package controllers;

import com.sun.glass.events.KeyEvent;
import models.Entity.EnittyForTesting;
import models.StateModel.PlayStateModel;
import utilities.Direction.Direction;
import utilities.KeyCommand;

/**
 * Created by jcvarela on 4/15/2016.
 */
public class PlayStateController extends Controller{

    private PlayStateModel model;

    public PlayStateController(PlayStateModel mdoel){
        this.model = mdoel;
    }

    @Override
    public void loadKeyCommand() {
        map.put(KeyEvent.VK_Q, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.NorthWest);} });

        map.put(KeyEvent.VK_W, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.North);} });
        map.put(KeyEvent.VK_E, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.NorthEast);} });
        map.put(KeyEvent.VK_A, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.SouthWest);} });
        map.put(KeyEvent.VK_S, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.South);} });
        map.put(KeyEvent.VK_D, new KeyCommand() {
            public void execute(){
                model.setFocusDirection(Direction.SouthEast);} });

        map.put(KeyEvent.VK_ENTER, new KeyCommand() {
            public void execute(){
                ((EnittyForTesting)model.getFocus()).setLocation(model.getFocus().getLocation().add(0,0,1));} });
        map.put(KeyEvent.VK_SPACE, new KeyCommand() {
            public void execute(){
                ((EnittyForTesting)model.getFocus()).setLocation(model.getFocus().getLocation().add(0,0,-1));} });

    }
}
