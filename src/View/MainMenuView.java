package View;

import java.awt.*;

public class MainMenuView extends View {

    public MainMenuView(){
        super(300,400);
    }

    @Override
    protected void render(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect(0,0,100,100);
    }

}

