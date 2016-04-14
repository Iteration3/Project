package views;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/12/16.
 */
public class Canvas extends JPanel{

    private final static int WIDTH = 500;
    private final static int HEIGHT = WIDTH*4/5;
    private final static int SCALE = 1;

    private View currentView;
    private Graphics2D g;

    //Constructs the canvas to paint things on
    public Canvas(){
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
    }

    public BufferedImage getImage(){
        return new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_4BYTE_ABGR);
    }

    public Graphics2D getGraphics(){
        return g;
    }

    //set the active view
    public void setActiveView(View view){
        this.currentView = view;
    }

    //Render the current view
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentView.render(g);
    }
}
