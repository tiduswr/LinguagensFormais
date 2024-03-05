package com.tiduswr;

public class Util {
    public static void printCharDestacado(String s, int index){
        System.out.print(s.substring(0, index));
        System.out.printf("<<%s>>", s.charAt(index));
        System.out.print(s.substring(index + 1));
    }
}
