/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

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
     * Effectively converts the passed Base 2 string, that is consisting of just 1 and 0 to string, in form of characters(ASCII or Unicode),.
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
