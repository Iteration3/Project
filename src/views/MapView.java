package views;



import models.Map.Map;
import models.Map.Terrain;
import models.Map.Tile;
import utilities.Geometry.Hexagon;
import utilities.Location.Location;

import java.awt.*;
import java.awt.image.BufferedImage;


public class MapView {

    //Title Variables
    public static final int TILE_LENGTH = 4 * Hexagon.X_LENGTH;
    public static final int TILE_WIDTH = 4 * Hexagon.Y_LENGTH;
    public static final int TILE_HEIGHT = 30;

    //Location and Map
    private Location center;
    private Map map;
    private int width;
    private int height;

    public MapView(Map map) {

        this.map = map;
    }

    public void setCenter(Location pos){
        this.center = pos;
    }


    protected void render(int width,int height, Graphics g) {
        this.width = width;
        this.height = height;

        int tileHeight = TILE_HEIGHT;

        //TODO:NOT HERE
        int heightOnScreen = 2;

        int heightStart = center.getHeight() - heightOnScreen/2;
        int heightEnd = center.getHeight() + 1; //+ heightOnScreen/2 + 1;


        int drawYincrement = tileHeight + 1;



        int drawX = width/2;
        int drawY = height/2 + (center.getHeight() - heightStart)*drawYincrement;

        float alpha = 0.08f;

        for(int h = heightStart; h < heightEnd; h++){
            renderHightAt(h,drawX,drawY,g);

            g.setColor(new Color(0f,0f,0f, alpha));
            g.fillRect(0,0,width,height);
            alpha += 0.15f;

            drawY -= drawYincrement;
        }
    }

    private void renderHightAt(int height, int centerX, int centerY, Graphics g){
        int tileWidth = TILE_WIDTH;

        //TODO:NOT HERE
        int rowOnScreen = 9;

        int rowStart = center.getRow() - rowOnScreen/2;
        int rowEnd = center.getRow() + rowOnScreen/2 + 1;

        int drawYIncrement = tileWidth + 1;

        int drawX = centerX;
        int drawY = centerY - drawYIncrement/2 -(center.getRow() - rowStart)*drawYIncrement;

        for(int r = rowStart; r < rowEnd; r++){
            renderRowAtHeight(r,height,drawX,drawY,g);
            drawY += drawYIncrement;
        }
    }

    private void renderRowAtHeight(int row,int height, int centerX, int centerY, Graphics g){

        int tileLength = TILE_LENGTH;
        int tileWidth = TILE_WIDTH;

        //TODO:NOT HERE
        int colOnScreen = 7;


        int colStart = center.getCol() - colOnScreen/2;
        int colStart2 = colStart;

        int colEnd = center.getCol() + colOnScreen/2 + 1;

        if(colStart%2 != 0) {
            colStart++;
        }else {
            colStart2++;
        }

        int space = 1;
        int drawXIncrement = tileLength*3/4 + 1;

        int drawX = centerX - (center.getCol() - colStart)*drawXIncrement;
        int drawY = centerY - tileWidth/4;

        for(int c = colStart; c < colEnd; c += 2){
            renderTileAt(drawX, drawY, new Location(row, c, height), g);

            drawX += 2*drawXIncrement;
        }

        drawX = centerX - (center.getCol() - colStart2)*drawXIncrement;
        drawY = space + centerY + tileWidth/4;

        for(int c = colStart2; c < colEnd; c += 2){
            renderTileAt( drawX,drawY , new Location(row,c,height),g);

            drawX += 2*drawXIncrement;
        }

    }

    private void renderTileAt(int x, int y, Location pos, Graphics g){
        Tile tile = map.getTileAt(pos);
        if(tile == null) {
            return;
        }
        renderTerrain(x,y,tile,g);

        renderEntityAt(x,y, tile ,g);
    }

    private void renderTerrain(int x, int y, Tile tile, Graphics g){
        Terrain temp = tile.getTerrain();
        if(temp == null) {
            return;
        }

        BufferedImage image = temp.getImage();
        g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
    }

    private void renderEntityAt(int x, int y, Tile tile, Graphics g){
//        Entity temp = tile.getEntity();
//        if(temp == null) {
//            return;
//        }
        // BufferedImage image = temp.getImage();
        // g.drawImage(image,x - image.getWidth()/2,y - image.getHeight()/2,null);
    }

}