package models.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import utilities.Geometry.Hexagon;
import utilities.Location.Location;
import utilities.SaveLoad.Saveable;

import java.util.HashMap;


public class Map implements Saveable {


    private HashMap<Location, Tile> tiles;

    //maximum size of the map once its been created cannot be change
    private int rowSize;
    private int colSize;
    private int heightSize;

    public Map(int rowSize, int colSize, int heightSize){
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.heightSize = heightSize;
        tiles = new HashMap<>();
    }

    public boolean isOutOfBound(Location loc){
        if (loc.getRow() < 0 || loc.getRow() >= getRowSize()) {
            return true;
        }
        if (loc.getCol() < 0 || loc.getCol() >= getColSize()) {
            return true;
        }
        if (loc.getHeight() < 0 || loc.getHeight() >= getHeightSize()) {
            return true;
        }
        return false;
    }

    public boolean isTileEmpty(Location loc){
        if(isOutOfBound(loc)) {
            return false;
        }
        return tiles.containsKey(loc);
    }

    public int getRowSize(){return rowSize;}
    public int getColSize(){return colSize;}
    public int getHeightSize(){return heightSize;}

    public Tile getTileAt(Location loc){
        if(isOutOfBound(loc)) {
            return null;
        }
        if(!tiles.containsKey(loc)) {
            return getDefaultTile();
        }
        else {
            return tiles.get(loc);
        }
    }

    public Tile getDefaultTile(){
        Tile temp = new Tile(Terrain.Air);
        return temp;
    }

    public void addTileAt(Tile tile, Location loc){
        if(isOutOfBound(loc)) {
            return;
        }
        else {
            tiles.put(loc, tile);
        }
    }
    public void removeTileAt(Location loc){
        if(tiles.containsKey(loc)){
            tiles.remove(loc);
        }
    }

    @Override
    public Element generateXml(Document doc) {
        Element e = doc.createElement("map");
        e.setAttribute("rows", Integer.toString(rowSize));
        e.setAttribute("cols", Integer.toString(colSize));
        e.setAttribute("height", Integer.toString(heightSize));
        for (Location l : tiles.keySet()) {
            Element tile = doc.createElement("map-tile");
            tile.appendChild(l.generateXml(doc));
            tile.appendChild(tiles.get(l).generateXml(doc));
            e.appendChild(tile);
        }
        return e;
    }

    public static Map fromXmlDocument(Document doc) {
        Element e = (Element)doc.getElementsByTagName("map").item(0);
        int rowSize = Integer.parseInt(e.getAttribute("rows"));
        int colSize = Integer.parseInt(e.getAttribute("cols"));
        int heightSize = Integer.parseInt(e.getAttribute("height"));
        Map m = new Map(rowSize,  colSize, heightSize);
        NodeList nodes = e.getElementsByTagName("map-tile");
        for (int i = 0; i < nodes.getLength(); ++i) {
            Element tile = (Element) nodes.item(i);
            Location l = Location.fromXmlElement((Element) tile.getElementsByTagName("location").item(0));
            Tile t = Tile.fromXmlElement((Element) tile.getElementsByTagName("tile").item(0));
            m.tiles.put(l, t);
        }
        return m;
    }
}


