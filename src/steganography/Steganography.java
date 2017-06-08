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

import javax.swing.JOptionPane;

/**
 * The test class. No such significance.
 * @author aniruddha
 */
public class Steganography {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String s=JOptionPane.showInputDialog("Enter a String:");
        System.out.println(s);
        String k=Utils.base2encode(s, 8);
        System.out.println(k);
        String d=Utils.base2decode(k, 8);
        System.out.println(d);
        if(s.equals(d))System.out.println("Success");
        else System.out.println(s.compareTo(d)+" Failure");
    }
    
}
