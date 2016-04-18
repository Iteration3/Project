package models.Map;


import controllers.Locomotion;
import views.DrawTerrainImages;

import java.awt.*;
import java.awt.image.BufferedImage;

public enum Terrain {
    Air(DrawTerrainImages.getAirImage()){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToAir();
        }
    }
    ,Grass(DrawTerrainImages.makeHalfTerrain(new Color(200,150,50), new Color(150,230,50))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToGround();
        }
    }
    ,Mountain(DrawTerrainImages.getFullTerrain(new Color(150,100,0),new Color(100,50,0))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToMountain();
        }
    }
    ,
    WaterSurface(DrawTerrainImages.makeHalfTerrain(new Color(0,0,190), new Color(0,100,250))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToWater();
        }
    }
    ,ShallowWater(DrawTerrainImages.makeHalfTerrain(new Color(100,250,250), new Color(173,255,255))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToGround();
        }
    },
    Water(DrawTerrainImages.makeHalfTerrain(new Color(0,150,250), new Color(0,255,255))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToWater();
        }
    },Bridge(DrawTerrainImages.makeHalfTerrain(new Color(150,150,150), new Color(200,200,200))){
        @Override
        public void moveTo(Locomotion locomotion) {
            locomotion.moveToGround();
        }
    }  ;


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