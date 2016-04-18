package models.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import utilities.SaveLoad.Saveable;
import views.DrawTerrainImages;

import controllers.Locomotion;
import java.awt.image.BufferedImage;

public enum Terrain implements Saveable {
    Air(DrawTerrainImages.getAirImage()){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToAir();
        }
    }
    ,Grass(DrawTerrainImages.getGrassImage()){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToGround();
        }
    }
    ,Mountain(DrawTerrainImages.getMountainImage()){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToMountain();
        }
    }
    ,Water(DrawTerrainImages.getAirImage()){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToWater();
        }
    };

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

    public static Terrain fromXmlElement(Element terrain) {
        return Terrain.valueOf(terrain.getTextContent());
    }

    public abstract void moveTo(Locomotion locomotion);
}

