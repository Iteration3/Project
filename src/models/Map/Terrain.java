package models.Map;


import controllers.Locomotion;
import views.DrawTerrainImages;
import java.awt.image.BufferedImage;

public enum Terrain {
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

    public abstract void moveTo(Locomotion locomotion);
}

/*
public enum Terrain {
    Grass(DrawTerrainImages.getGrassImage())
    ,Mountain(DrawTerrainImages.getMountainImage())
    ,Air(DrawTerrainImages.getAirImage());


}
*/