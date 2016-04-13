package views;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by denzel on 4/11/16.
 */
public abstract class View{

    private int width = 100;
    private int height = 100;

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public final void render(BufferedImage image){
        width = image.getWidth();
        height = image.getWidth();

        Graphics2D g = image.createGraphics();
        render(g);
    }

    protected abstract void render(Graphics2D g);
}
