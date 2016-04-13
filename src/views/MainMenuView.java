package views;

import models.StateModel.MainMenuModel;

import java.awt.*;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuView extends View {

    private MainMenuModel model;

    public MainMenuView(MainMenuModel model){
        this.model = model;
    }

    @Override
    protected void render(Graphics2D g) {
        renderBackGround(g);
        renderOption(g);
    }

    private void renderBackGround(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
    }

    private void renderOption(Graphics2D g){
        
    }
}

