/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import javax.swing.JOptionPane;

/**
 *
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
        String k=Utils.generateInteger(s, 8);
        System.out.println(k);
        String d=Utils.generateString(k, 8);
        System.out.println(d);
        if(s.equals(d))System.out.println("Success");
        else System.out.println(s.compareTo(d)+" Failure");
    }
    
}