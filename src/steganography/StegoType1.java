/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author aniruddha
 */
public class StegoType1 {
    public boolean loadImage(Path filePath){
        try {
            
            base=ImageIO.read(Files.newInputStream(filePath));
            return true;
        } catch (IOException ex) {
            Logger.getLogger(StegoType1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean construct(int shift,String message){
        
        return true;
    }
    private BufferedImage base,constructed;
}
