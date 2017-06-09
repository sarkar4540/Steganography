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
package steganography;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Steganography Type I.
 * @author aniruddha
 */
public class StegoType1 implements Stego{
    @Override
    public void setImage(BufferedImage image) {
        base=image;
    }
    BufferedImage base,impl=null;
    String message=null;
    @Override
    public BufferedImage getImage() {
        return (impl==null)?base:impl;
    }

    @Override
    public void setMessage(String message) {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    private boolean stegbuild(){
        String s=Utils.base2encode(message+((char)0), 8);
        int width=base.getWidth(),height=base.getHeight(),count=0,length=s.length();
        impl=new BufferedImage(width,height,base.getType());
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                int databit=s.charAt(count++%length)-'0';
                int color=base.getRGB(i, j);
                
                int red=color>>16&0xFF;//getting red component;
                red=((red%2==0)?red:red-1)+databit;//putting the databit in the lsb of red
                if(red<0)red+=2;//checking out of bounds, if out of bounds, the value is changed keeping the lsb same.
                if(red>255)red-=2;
                
                int blue=color>>8&0xFF;
                blue=((blue%2==0)?blue:blue-1)+databit;//now for blue...
                if(blue<0)blue+=2;
                if(blue>255)blue-=2;
                
                int green=color&0xFF;
                green=((green%2==0)?green:green-1)+databit;//now for green...
                if(green<0)green+=2;
                if(green>255)green-=2;
                
                color=(red<<16|green<<8|blue);
                impl.setRGB(i, j, color);
            }
        }
        return true;
    }
    @Override
    public boolean process(int type) {
        if(type==STEGANOGRAPH)return stegbuild();
        else throw new UnsupportedOperationException("Not supported yet.");
        
        //To change body of generated methods, choose Tools | Templates.
    }
}
