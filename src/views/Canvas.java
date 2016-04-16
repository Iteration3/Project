package views;


import Main.InputManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/12/16.
 */
public class Canvas extends JPanel implements KeyListener{

    private final static int WIDTH = 500;
    private final static int HEIGHT = WIDTH*4/5;
    private final static int SCALE = 1;

    private View currentView;
    private Graphics2D g;
    private InputManager inputManager;

    //Constructs the canvas to paint things on
    public Canvas(InputManager inputManager){
        this.inputManager = inputManager;
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);
    }


    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
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
        if(currentView!=null){
            currentView.render(g);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       inputManager.removeCommand(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        inputManager.getActiveKey(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
