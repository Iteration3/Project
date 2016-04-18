package views;

import models.StateModel.InventoryViewModel;
import models.StateModel.PlayStateModel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Implemented by Peter Camejo
 */
public class InventoryView extends View{
    private final String TITLE = "Inventory";

    private Font titleFont;

    private InventoryViewModel model;

    public InventoryView(int width, int height, Canvas canvas, InventoryViewModel model){
        super(width,height , canvas);
    }

    @Override
    protected void render(Graphics g) {
        BufferedImage image = new BufferedImage(getScreenWidth(),getScreenHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = image.createGraphics();

        renderTitle(g2);

        g.drawImage(image,(int)(getScreenWidth()*0.2),(int)( getScreenHeight()*0.2),(int)( getScreenWidth()*0.6),(int)( getScreenHeight()*0.6),null);

    }

    private void renderTitle(Graphics g) {
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .1));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g);


        int x = getScreenWidth() / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g.setColor(Color.WHITE);
        g.drawString(TITLE, x, y);

    }

    private void renderSlots(Graphics g){
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .05));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Color selectedColor = Color.WHITE;
        Color regularColor = Color.WHITE;
        g.setColor(regularColor);

        int xpos = 50;
        int ypos = 50;
        for(int  i = 0 ; i < 22 ; i++){
            if(model.getCurrentIndex() == i){
                g.setColor(selectedColor);
                g.fillRect(xpos++ , ypos , 10 ,10);
            }else{
                g.setColor(regularColor);
                g.fillRect(xpos++ , ypos , 10 , 10);

            }
            g.drawImage(model.getItemImageAt(i) , 0 , 0 , 50 , 50 , null );
        }



    }
}
