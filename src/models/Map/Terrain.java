package models.Map;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;
import views.Assets;
import views.other.DrawTerrainImages;

import java.awt.image.BufferedImage;

public enum Terrain implements Saveable {
    Grass(DrawTerrainImages.getGrassImage())
    ,Mountain(DrawTerrainImages.getMountainImage())
    ,Air(DrawTerrainImages.getAirImage());

    private BufferedImage image;

    Terrain(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }

    @Override
    public Element generateXml(Document doc) {
        Element element = doc.createElement("terrain");
        element.setTextContent(this.toString());
        return element;
    }
}

