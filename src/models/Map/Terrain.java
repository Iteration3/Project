package models.Map;



import controllers.Locomotion;
import views.DrawTerrainImages;

import java.awt.image.BufferedImage;

public abstract class Terrain {

    private BufferedImage image;

    public Terrain(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }

    public abstract void moveTo(Locomotion locomotion);
}

/*
public enum Terrain {
    Grass(DrawTerrainImages.getGrassImage())
    ,Mountain(DrawTerrainImages.getMountainImage())
    ,Air(DrawTerrainImages.getAirImage());


}
*/