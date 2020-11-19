package com.syousui.mildintegratedmanagesystem.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : SpringUtil.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.utils
 * @createTime : 2020-11-19 11:21:00 星期四
 * @Description : TODO
 */

@Component ()
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /**
     * Spring容器会在创建该 Bean 之后，自动调用该 Bean 的 setApplicationContext 方法
     *
     * @param applicationContext 应用上下文
     * @throws BeansException 直接抛出异常
     */
    @Override
    public void setApplicationContext ( ApplicationContext applicationContext ) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    // 获取 applicationContext
    public static ApplicationContext getApplicationContext ( ) {
        return SpringUtil.applicationContext;
    }

    // 通过 name获取 Bean.
    public static Object getBean ( String name ) {
        return SpringUtil.getApplicationContext( ).getBean( name );
    }

    // 通过 class 获取 Bean.
    public static <T> T getBean ( Class<T> clazz ) {
        return SpringUtil.getApplicationContext( ).getBean( clazz );
    }

    // 通过 name, 以及 Clazz 返回指定的 Bean
    public static <T> T getBean ( String name, Class<T> clazz ) {
        return SpringUtil.getApplicationContext( ).getBean( name, clazz );
    }
}
