package com.syousui.mildintegratedmanagesystem.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : JsonUtil.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.utils
 * @createTime : 2020-11-20 10:42:00 星期五
 * @Description : TODO
 */

public class JsonUtil {
    // SpringBoot 内置 Jackson, 故直接从容器之中拿来即可.
    private static final ObjectMapper objectMapper = SpringUtil.getBean( ObjectMapper.class );

    public static <T> String beanToJson ( T obj ) {
        if ( obj == null ) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString( obj );
        } catch ( Exception e ) {
            e.printStackTrace( );
            return null;
        }
    }

//    由于 SpringMVC 完全可以使用注解来灵活应对各种参数, 此处的转换就没有意义了.
//    public static <T> T jsonToBean ( String str, Class<T> clazz ) {
//        if ( "".equals( str ) || clazz == null ) {
//            return null;
//        }
//        try {
//            return clazz.equals( String.class ) ? (T) str : objectMapper.readValue( str, clazz );
//        } catch ( Exception e ) {
//            e.printStackTrace( );
//            return null;
//        }
//    }

    public static List<Integer> jsonNodeToIntList ( JsonNode jsonNode ) {
        List<Integer> list = new ArrayList<>( );
        for ( JsonNode node : jsonNode ) {
            list.add( node.asInt( ) );
        }
        return list;
    }
}
