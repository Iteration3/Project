package models.Map;


import views.Assets;
import views.other.DrawTerrainImages;

import java.awt.image.BufferedImage;

public enum Terrain {
    Air(DrawTerrainImages.getAirImage())
    ,Grass(DrawTerrainImages.getGrassImage())
    ,Mountain(DrawTerrainImages.getMountainImage());

    private BufferedImage image;

    Terrain(BufferedImage image){
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }
}

