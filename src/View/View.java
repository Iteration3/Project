package View;

import javax.swing.*;
import java.awt.*;


/**
 * Created by denzel on 4/11/16.
 */
public abstract class View extends JPanel{

    //the veggies
    protected int height;
    protected int width;




    //constructor
    public View(int height, int width){
        this.height = height;
        this.width = width;

        this.setPreferredSize(new Dimension(width,height));

    }

    public void setFocus(){
        this.setFocusable(true);
        this.requestFocus();
    }

    //render method
    protected abstract void render(Graphics2D g);

}
