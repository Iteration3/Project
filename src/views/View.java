package views;

import java.awt.*;


/**
 * Created by denzel on 4/11/16.
 */
public abstract class View{

    //the veggies
    protected int height;
    protected int width;
    protected Canvas canvas;

    //constructor
    public View(int height, int width, Canvas canvas){
        this.height = height;
        this.width = width;
        this.canvas = canvas;
    }

    //returns height
    public int getHeight(){
        return height;
    }

    //returns width
    public int getWidth(){
        return width;
    }

    //returns Canvas
    public Canvas getCanvas(){
        return canvas;
    }

    //render method
    protected abstract void render(Graphics g);
}
