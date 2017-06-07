/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.util.Optional;

/**
 *
 * @author aniruddha
 */
public class Utils {
    public static String generateInteger(String str,int charSize){
        int i,j,length=str.length(),remainder,character;
        StringBuilder ret=new StringBuilder(length*charSize);
        System.out.println(length*charSize);
        for(i=0;i<length;i++){
            ret.append(leftpad(Integer.toBinaryString(str.charAt(i)),charSize,'0'));
        }
        return ret.toString();
    }
    public static String generateString(String integer,int charSize){
        int count=0,length=integer.length(),i,character;
        StringBuilder ret=new StringBuilder(length/charSize);
        while(count<length){
            character=0;
            for(i=0;i<charSize;i++){
                character=character<<1;
                character+=integer.charAt(count++)-'0';
            }
            ret.append((char)character);
        }
        return ret.toString();
    }
    static String leftpad(String s, int nb, char pad) {
        return Optional.of(nb - s.length())
                .filter(i -> i > 0)
                .map(i-> String.format("%" + i + "s", "").replace(" ", pad + "") + s)
                .orElse(s);
    }
}
