package models.Map;

import controllers.Locomotion;
import models.Map.Terrain;
import views.DrawTerrainImages;

import java.awt.image.BufferedImage;

/**
 * Created by clayhausen on 4/16/16.
 */
public class MountainTerrain extends Terrain {

    public MountainTerrain(BufferedImage image){
        super(DrawTerrainImages.getMountainImage());
    }

    @Override
    public void moveTo(Locomotion locomotion) {
        locomotion.moveToMountain();
    }
}
