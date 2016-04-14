package views;

import models.StateModel.MainMenuModel;
import views.View;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class MainMenuView extends View {

    // Constants
    private final String TITLE = "Kanye 2020";

    // Scalable variables.
    private int buttonWidth;
    private int buttonHeight;
    // Styling properties
    private Font titleFont;
    private Font generalFont;
    private int titleButtonMargin;

    private MainMenuModel model;
    // Data properties
    public MainMenuView(int width, int height, Canvas canvas,MainMenuModel model) {
        super(width, height, canvas);
        this.model = model;
    }




    @Override
    public void render(Graphics g) {

        renderBackground(g);
        renderTitle(g);
        renderButtons(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void renderBackground(Graphics g) {

    }

    private void renderTitle(Graphics g) {
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();
        int titleWidth = fm.stringWidth(TITLE);
        int x = getScreenWidth() / 2 - titleWidth / 2;
        int y = fm.getHeight();
        g.setColor(Color.white);
        g.drawString(TITLE, x, y);
    }

    private void renderButtons(Graphics g) {

        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        int x = getScreenWidth()*6/10;
        int y = getScreenHeight()*4/10;

        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;

        for(MainMenuModel.MainMenuOption option: MainMenuModel.MainMenuOption.values()){
            Rectangle2D rectangle = fm.getStringBounds(option.toString(),g);

            if(option.toString().equals(model.getSelected().toString())){
                g.setColor(selectedColor);
                g.drawString(option.toString(), x, y);
            } else {
                g.setColor(defaultColor);
                g.drawString(option.toString(), x, y);
            }
            y += fm.getHeight();
        }
    }


}