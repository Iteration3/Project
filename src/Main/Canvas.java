package Main;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel{

    public static final int WIDTH = 300;
    public static final int HEIGHT = 300;

    public static final int SCALE = 3;


    @Override
    public Dimension getPreferredSize(){
        return new Dimension(300,300);
    }

    public void paint(Graphics g){
        paintComponent(g);
    }
}
