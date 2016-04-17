package models.Map;

import controllers.Locomotion;
import views.DrawTerrainImages;

import java.awt.image.BufferedImage;

/**
 * Created by clayhausen on 4/16/16.
 */
public class GroundTerrain extends Terrain {

    public GroundTerrain(BufferedImage image){
        super(DrawTerrainImages.getGrassImage());
    }

    @Override
    public void moveTo(Locomotion locomotion) {
        locomotion.moveToGround();
    }
}
