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
     * The values can be either STEGANOGRAPH or STEGANALYZE as defined by the interface or any other value if described by the class.
     * @return Returns true if it has successfully completed the job it has to do, else you know what!
     */
    public boolean process(int type);
}
