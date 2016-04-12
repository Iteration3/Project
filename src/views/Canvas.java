package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by denzel on 4/12/16.
 */
public class Canvas extends JPanel{

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
}
