package views.StateView;

import models.StateModel.InventoryEquipmentModel;
import views.View;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Implemented by Peter Camejo
 */
public class InventoryEquipmentView extends View {
    //SCREEN DIMENSION
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    private static final String TITLE = "Inventory";
    private static final Font TITLE_FONT = new Font("Calibri (Body)", Font.BOLD, (int)(HEIGHT*0.2));

    private static final Font VIEW_FONT = new Font("Calibri (Body)", Font.PLAIN, (int)(HEIGHT*0.05));

    private InventoryEquipmentModel model;

    private InventoryEquipmentView(InventoryEquipmentModel model){
        this.model = model;
    }

    public void render(Graphics2D g) {

        BufferedImage overImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g2 = overImage.getGraphics();

        // How to render playState in the back?
       //renderBackground(g2);

        renderTitle(g2);



        //renderInventoryEquipment(g2);

        int w = getWidth();
        int h = getHeight();

        g.drawImage(overImage, 0, 0 , w ,h , null);
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


}
