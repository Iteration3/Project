package views;

import views.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/12/16.
 */
public class Canvas extends JPanel{


    private final static int WIDTH = 500;
    private final static int HEIGHT = WIDTH*4/5;

    private final static int SCALE = 1;

    //Constructs the canvas to paint things on
    public Canvas(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    public BufferedImage getImage(){
        return new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
    }

    public void repaint(BufferedImage imageToRender){
        Graphics g2 = super.getGraphics();
        g2.drawImage(imageToRender, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        g2.dispose();
    }
}
