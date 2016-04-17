package models.Map;

import controllers.Locomotion;
import views.DrawTerrainImages;

import java.awt.image.BufferedImage;

/**
 * Created by clayhausen on 4/16/16.
 */
public class AirTerrain extends Terrain {

    public AirTerrain(BufferedImage image){
        super(DrawTerrainImages.getAirImage());
    }

    @Override
    public void moveTo(Locomotion locomotion) {
        locomotion.moveToAir();
    }
}
