package com.syousui.mildintegratedmanagesystem;

/**
 * @author : TouSan
 * @version : 1.0.0
 * @ClassName : Temp.java
 * @PackageLocation : com.syousui.mildintegratedmanagesystem
 * @Email : acmaker@foxmail.com
 * @createTime : 2020-12-30 16:47:00 星期三
 * @Description : TODO
 */

public class Temp {
    public static void main ( String[] args ) {
        char c = '\0';
        for ( int i =  1;  i <=4; ++i ) {
            switch (i) {
                case 1:
                    c = 'b';
                    System.out.println( c );
                case 2:
                    c = 'e';
                    System.out.println( c );
                    break;
                case 3:
                    c = 'p';
                    System.out.println( c );
                default:
                    System.out.println( '!' );
            }
        }
    }
}
