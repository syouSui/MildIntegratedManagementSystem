package com.syousui.mildintegratedmanagesystem.listener;

import com.syousui.mildintegratedmanagesystem.utils.WebUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.LinkedList;

/**
 * @author : TouSan
 * @version : 1.0.0
 * @ClassName : OnlineNumberListener.java
 * @PackageLocation : com.syousui.mildintegratedmanagesystem.listener
 * @Email : acmaker@foxmail.com
 * @createTime : 2020-11-24 10:38:00 星期二
 * @Description : TODO
 */

public class OnlineNumberListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {
//    private static long nowNum;
//
//    private static long nowNumMax;
//
//    @Override
//    public void contextInitialized ( ServletContextEvent sce ) {
//        WebUtil.setUserList( new LinkedList<>( ) );
//    }
//
//    @Override
//    public void contextDestroyed ( ServletContextEvent sce ) {
//    }
//
//    @Override
//    public void sessionCreated ( HttpSessionEvent se ) {
//        WebUtil.setSession( se.getSession() );
//        nowNum = WebUtil.getOnlineNumber( ) + 1;
//        WebUtil.setOnlineNumber( nowNum );
//        nowNumMax = WebUtil.getMaxOnlineNumber( );
//        WebUtil.setMaxOnlineNumber(
//                Math.max( nowNumMax, nowNum )
//        );
//    }
//
//    @Override
//    public void sessionDestroyed ( HttpSessionEvent se ) {
//        nowNum = WebUtil.getOnlineNumber( ) + 1;
//        WebUtil.setOnlineNumber( nowNum );
//        nowNumMax = WebUtil.getMaxOnlineNumber( );
//        WebUtil.setMaxOnlineNumber(
//                Math.max( nowNumMax, nowNum )
//        );
//        WebUtil.logOut( );
//        WebUtil.setSession( null );
//    }
//
//    @Override
//    public void requestInitialized ( ServletRequestEvent sre ) {
//
//    }
//
//    @Override
//    public void requestDestroyed ( ServletRequestEvent sre ) {
//
//    }

}
