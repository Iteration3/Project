package models.Decal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by walkhard on 4/7/16.
 */
public class Decal {

    BufferedImage bufferedImage;

    public Decal(String src){
        try {
            File img = new File(src);
            bufferedImage = ImageIO.read(img );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

}
