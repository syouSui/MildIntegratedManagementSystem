package com.syousui.mildintegratedmanagesystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : DateUtil.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.utils
 * @createTime : 2020-11-23 10:38:00 星期一
 * @Description : TODO
 */

public class DateUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss"
    );

    public static Date asDate ( String str ) {
        if ( "".equals( str ) ) return null;
        Date date = null;
        try {
            date = simpleDateFormat.parse( str );
        } catch ( ParseException e ) {
            e.printStackTrace( );
        }
        return date;
    }

    public static String asString ( Date date ) {
        return simpleDateFormat.format( date );
    }
}
