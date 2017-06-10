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
package ani.steganography.impl;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import ani.steganography.Stego;
import ani.steganography.StegoType1;
import ani.steganography.Utils;

/**
 *
 * @author aniruddha
 */
public class StegoType1Impl {
    public static void main(String a[]){
        StegoType1 st1=new StegoType1();
        JFileChooser jfc=new JFileChooser();
        switch(JOptionPane.showInputDialog("Enter [S]teganalysis or [B]uild:").toLowerCase().charAt(0)){
            case 'b':
                jfc.showOpenDialog(jfc);//Select the file
                st1.setImage(Utils.getImageFromPath(jfc.getSelectedFile().toPath()));
                st1.setMessage(JOptionPane.showInputDialog("Enter the message:"));
                st1.process(Stego.STEGANOGRAPH);
                jfc.showSaveDialog(jfc);
                Utils.saveImageToPath(st1.getImage(), jfc.getSelectedFile().toPath());
                break;
            case 's':
                jfc.showOpenDialog(jfc);//Select the file
                st1.setImage(Utils.getImageFromPath(jfc.getSelectedFile().toPath())); 
                st1.process(Stego.STEGANALYZE);
                JOptionPane.showMessageDialog(null, st1.getMessage());
                break;
        }
    }
}
