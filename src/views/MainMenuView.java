package views;

import java.awt.*;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuView extends View {

    public MainMenuView(int height, int width, Canvas canvas){
        super(height, width, canvas);
    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(20,20,300,300);
    }

}

