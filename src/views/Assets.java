package views;


import java.awt.image.BufferedImage;


/**
 * Implemented by Peter Camejo
 */
public class Assets {
    private static final int width = 32, height = 32;

    /* Weapons */
    public static BufferedImage oneHand;
    public static BufferedImage twoHand;
    public static BufferedImage fist;
    public static BufferedImage ranged;
    public static BufferedImage staff;

    /* Armor */
    public static BufferedImage headArmor;
    public static BufferedImage chestArmor;
    public static BufferedImage legArmor;
    public static BufferedImage gloveArmor;
    public static BufferedImage bootArmor;
    public static BufferedImage trinket;

    /* Terrain */
    public static BufferedImage grassTerrain;
    public static BufferedImage mountainTerrain;
    public static BufferedImage airTerrain;

    public static BufferedImage BGIMAGE;

    /* Methods */
    public static void init() {


        SpriteSheet oneHandSheet = new SpriteSheet(new ImageLoader().loadImage("/oneHand.png"));
        SpriteSheet twoHandSheet = new SpriteSheet(new ImageLoader().loadImage("/twoHand.png"));
        SpriteSheet fistSheet = new SpriteSheet(new ImageLoader().loadImage("/fist.png"));
        SpriteSheet staffSheet = new SpriteSheet(new ImageLoader().loadImage("/staff.png"));
        SpriteSheet rangedSheet = new SpriteSheet(new ImageLoader().loadImage("/ranged.png"));

        SpriteSheet headArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/headArmor.png"));
        SpriteSheet chestArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/chestArmor.png"));
        SpriteSheet legArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/legArmor.png"));
        SpriteSheet gloveArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/gloves.png"));
        SpriteSheet bootArmorSheet = new SpriteSheet(new ImageLoader().loadImage("/bootArmor.png"));
        SpriteSheet trinketSheet = new SpriteSheet(new ImageLoader().loadImage("/trinket.png"));

        oneHand = oneHandSheet.crop(0 , 0, width , height);
        twoHand = twoHandSheet.crop(0, 0 , width , height);
        fist = fistSheet.crop(0 , 0 , width , height);
        staff = staffSheet.crop(0 , 0 ,width , height);
        ranged = rangedSheet.crop(0 , 0 , width , height);

        headArmor = headArmorSheet.crop(0 , 0 ,width , height);
        chestArmor = chestArmorSheet.crop(0 , 0 , width , height);
        legArmor = legArmorSheet.crop(0 , 0 , width , height);
        gloveArmor = gloveArmorSheet.crop(0 , 0 , width , height);
        bootArmor = bootArmorSheet.crop(0 , 0 , width , height);
        trinket = trinketSheet.crop(0 , 0 , width , height);

        /*
        grassTerrain = DrawTerrainImages.getGrassImage();
        mountainTerrain = DrawTerrainImages.getMountainImage();
        airTerrain = DrawTerrainImages.getAirImage();
        */

        BGIMAGE = new ImageLoader().loadImage("/BackGround.jpg");
    }
}
