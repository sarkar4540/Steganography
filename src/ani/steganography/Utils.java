/*
 * Copyright (C) 2017 aniruddha
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ani.steganography;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *The utility package consistng of static methods used in the library for steganography.
 * @author aniruddha
 */
public class Utils {
    
    /**
     * Effectively converts the passed string, in form of characters(ASCII or Unicode), to Base 2 string, that is consisting of just 1 and 0.
     * @param str The string to be encoded.
     * @param charSize The maximum size of each character that makes up the string in bits.
     * @return The base 2 encoded string.
     */
    public static String base2encode(String str,int charSize){
        int i,j,length=str.length(),remainder,character;
        StringBuilder ret=new StringBuilder(length*charSize);
        System.out.println(length*charSize);
        for(i=0;i<length;i++){
            ret.append(leftpad(Integer.toBinaryString(str.charAt(i)),charSize,'0'));
        }
        return ret.toString();
    }
    
    /**
     * Effectively converts the passed Base 2 string, that is consisting of just 1 and 0 to string, in form of characters(ASCII or Unicode), until a null character is interpreted.
     * @param str The string to be decoded.
     * @param charSize The maximum size of each character that makes up the string in bits.
     * @return The decoded string from base 2.
     */
    public static String base2decode(String str,int charSize){
        int count=0,length=str.length(),i,character;
        StringBuilder ret=new StringBuilder(length/charSize);
        while(count<length){
            character=0;
            for(i=0;i<charSize;i++){
                character=character<<1;
                character+=str.charAt(count++)-'0';
            }
            if(character==0)break;
            ret.append((char)character);
        }
        return ret.toString();
    }
    
    /**
     * Reads an image from a path to the file.
     * @param filePath path to the file.
     * @return image from the file.
     */
    public static BufferedImage getImageFromPath(Path filePath){
        try {
            return ImageIO.read(Files.newInputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(StegoType1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * Writes an image to path.
     * @param image The data of the image.
     * @param filePath the path to the file.
     * @return true if success else you know what!
     */
    public static boolean saveImageToPath(BufferedImage image,Path filePath){
        try {
            return ImageIO.write(image, "png", Files.newOutputStream(filePath));
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    /**
     * An implementation of Apache commons leftpad.
     * @param s String to be padded.
     * @param nb The width of the padding.
     * @param pad The characted with which it is to be padded.
     * @return The padded string.
     */
    private static String leftpad(String s, int nb, char pad) {
        return Optional.of(nb - s.length())
                .filter(i -> i > 0)
                .map(i-> String.format("%" + i + "s", "").replace(" ", pad + "") + s)
                .orElse(s);
    }
    
}
