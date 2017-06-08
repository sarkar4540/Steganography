/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.image.BufferedImage;

/**
 *The interface for Stego processes.
 * @author aniruddha
 */
public interface Stego {
    final int STEGANOGRAPH=1,STEGANALYZE=2;
    
    /**
     * Sets the image to be manipulated with.
     * @param image the image to be manipulated.
     */
    public void setImage(BufferedImage image);
    
    /**
     * Returns the image set. The image remains as is until process(int) is called. 
     * @return the image set.
     */
    public BufferedImage getImage();
    
    /**
     * Sets the message to be manipulated with.
     * @param message the message to be used.
     */
    public void setMessage(String message);
    
    /**
     * Returns the message set. The message remains as is until process(int) is called. 
     * @return the image set.
     */
    public String getMessage();
    
    /**
     * This method manipulates with the image set.
     * @param type The function may encode the image with the message, or may decode the mesage from the image depending on this argument.
     * @return Returns true if it has successfully completed the job it has to do, else you know what!
     */
    public boolean process(int type);
}
