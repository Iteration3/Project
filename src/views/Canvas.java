package views;

import views.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by denzel on 4/12/16.
 */
public class Canvas extends JPanel implements KeyListener{

    protected View currentView;

    //Constructs the canvas to paint things on
    public Canvas(int height, int width){
        setFocusable(true);
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(height, width));
    }

    //sets the current view of things
    public void setCurrentView(View view){
        currentView = view;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        currentView.render(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
