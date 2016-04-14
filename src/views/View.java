package views;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Created by denzel on 4/11/16.
 */
public abstract class View{

    private int width;
    private int height;
    private Canvas canvas;

    public View(int width, int height, Canvas canvas){
        this.width = width;
        this.height = height;
        this.canvas = canvas;
    }

    public int getScreenWidth(){
        return width;
    }
    public int getScreenHeight(){
        return height;
    }
    public Canvas getCanvas(){ return canvas; }

    protected abstract void render(Graphics g);
}
