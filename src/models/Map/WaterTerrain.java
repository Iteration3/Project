package models.Map;

import controllers.Locomotion;
import views.DrawTerrainImages;

import java.awt.image.BufferedImage;

/**
 * Created by clayhausen on 4/16/16.
 */
public class WaterTerrain extends Terrain {

    public WaterTerrain(BufferedImage image){
        //TODO needs to get a water tile
        super(DrawTerrainImages.getGrassImage());
    }

    @Override
    public void moveTo(Locomotion locomotion) {
        locomotion.moveToWater();
    }
}
