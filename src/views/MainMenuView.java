package views;

import models.StateModel.MainMenuModel;
import models.StateModel.MainMenuModel.MainMenuOption;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Created by denzel on 4/11/16.
 */
public class MainMenuView extends View {

    //SCREEN DIMENSION
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;


    //title
    private static final String TITLE = "Title Here";
    private static final Font TITLE_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.2));

    private static final Font VIEW_FONT = new Font("Calibri (Body)", Font.PLAIN, (int)(HEIGHT*0.05));

    private MainMenuModel model;

    public MainMenuView(MainMenuModel model){
        this.model = model;
    }

    @Override
    public void render(Graphics2D g) {
        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        renderBackground(g2);

        renderTitle(g2);

        renderButtons(g2);

        int w = getWidth();
        int h = getHeight();

        g.drawImage(overImage, 0, 0 , w ,h , null);
    }

    private void renderBackground(Graphics g){
        BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = overImage.getGraphics();

        g2.setColor(new Color(125,59,191));
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
    }

    private void renderTitle(Graphics g){
        BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();


        g2.setFont(TITLE_FONT);
        FontMetrics fm = g2.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g2);


        int x = WIDTH / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g2.setColor(new Color(0,100,255));
        g2.drawString(TITLE, x, y);

        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
    }

    private void renderButtons(Graphics g){
        BufferedImage overImage = new BufferedImage(WIDTH,HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        g2.setFont(VIEW_FONT);
        FontMetrics fm = g2.getFontMetrics();

        int x = WIDTH*6/10;
        int y = HEIGHT*4/10;

        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;

        for(MainMenuOption option: MainMenuOption.values()){
            Rectangle2D rectangle = fm.getStringBounds(option.toString(),g2);

            if(option.toString().equals(model.getSelected().toString())){
                g2.setColor(selectedColor);
                g2.drawString(option.toString(), x, y);
            } else {
                g2.setColor(defaultColor);
                g2.drawString(option.toString(), x, y);
            }

            y += fm.getHeight();
        }
        g.drawImage(overImage, 0, 0, WIDTH, HEIGHT, null);
    }
}

