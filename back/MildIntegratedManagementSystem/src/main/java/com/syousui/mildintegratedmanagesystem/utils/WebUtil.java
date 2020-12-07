package com.syousui.mildintegratedmanagesystem.utils;

import com.syousui.mildintegratedmanagesystem.pojo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : acmaker
 * @version : 1.0.0
 * @ClassName : WebUtil.java
 * @PackageLoaction : com.syousui.mildintegratedmanagesystem.utils
 * @createTime : 2020-11-24 08:45:00 星期二
 * @Description : TODO
 */

@Component
public class WebUtil implements ServletContextListener, HttpSessionListener, ServletRequestListener {
    @Autowired
    private static HttpSession session;

    @Autowired
    private static HttpServletRequest request;

    @Autowired
    private static ApplicationContext applicationContext;

    @Autowired
    private static HttpServletResponse response;

    private static List<User> userList = new LinkedList<User>( );

    private static long onlineNumber = 0;

    private static long maxOnlineNumber = 0;

//    private static long nowNum;
//
//    private static long nowNumMax;

    // default getter/setter
    public static HttpSession getSession ( ) {
        return session;
    }
    public static void setSession ( HttpSession session ) {
        WebUtil.session = session;
    }
    public static HttpServletRequest getRequest ( ) {
        return request;
    }
    public static void setRequest ( HttpServletRequest request ) {
        WebUtil.request = request;
    }
    public static ApplicationContext getApplicationContext ( ) {
        return applicationContext;
    }
    public static void setApplicationContext ( ApplicationContext applicationContext ) {
        WebUtil.applicationContext = applicationContext;
    }
    public static List<User> getUserList ( ) {
        return userList;
    }
    public static void setUserList ( List<User> userList ) {
        WebUtil.userList = userList;
    }
    public static HttpServletResponse getResponse ( ) {
        return response;
    }
    public static void setResponse ( HttpServletResponse response ) {
        WebUtil.response = response;
    }
    public static long getOnlineNumber ( ) {
        return onlineNumber;
    }
    public static void setOnlineNumber ( long onlineNumber ) {
        WebUtil.onlineNumber = onlineNumber;
    }
    public static long getMaxOnlineNumber ( ) {
        return maxOnlineNumber;
    }
    public static void setMaxOnlineNumber ( long maxOnlineNumber ) {
        WebUtil.maxOnlineNumber = maxOnlineNumber;
    }

    //    implements methods
    @Override
    public void contextInitialized ( ServletContextEvent sce ) {
        WebUtil.setUserList( new LinkedList<>( ) );
    }

    @Override
    public void contextDestroyed ( ServletContextEvent sce ) {
    }

    @Override
    public void sessionCreated ( HttpSessionEvent se ) {
        WebUtil.setSession( se.getSession( ) );
        long nowNum = WebUtil.getOnlineNumber( ) + 1;
        WebUtil.setOnlineNumber( nowNum );
        long nowNumMax = WebUtil.getMaxOnlineNumber( );
        WebUtil.setMaxOnlineNumber(
                Math.max( nowNumMax, nowNum )
        );
    }

    @Override
    public void sessionDestroyed ( HttpSessionEvent se ) {
        long nowNum = WebUtil.getOnlineNumber( ) + 1;
        WebUtil.setOnlineNumber( nowNum );
        long nowNumMax = WebUtil.getMaxOnlineNumber( );
        WebUtil.setMaxOnlineNumber(
                Math.max( nowNumMax, nowNum )
        );
        WebUtil.logOut( );
        WebUtil.setSession( null );
    }

    @Override
    public void requestInitialized ( ServletRequestEvent sre ) {

    }

    @Override
    public void requestDestroyed ( ServletRequestEvent sre ) {

    }

    // 业务逻辑
    public static void login ( User user ) {
        if ( userList.contains( user ) ) return;
        userList.add( user );
        System.out.println( user );
        session.setAttribute( "USER", user );
    }

    public static boolean logOut ( ) {
        boolean state = true;
        try {
            userList.remove( session.getAttribute( "USER" ) );
            session.removeAttribute( "USER" );
        } catch ( Exception e ) {
            e.printStackTrace( );
            state = false;
        }
        return state;
    }

    public static User fetchUser ( ) {
        return (User) session.getAttribute( "USER" );
    }

}

//监听器Listener
//        监听器Listener就是在application，session，request三个对象创建、销毁或者往其中添加修改删除属性时自动执行代码的功能组件。
//        Listener是Servlet的监听器，可以监听客户端的请求和服务端的操作等。
//        主要有下面三类监听器：
//        1、ServletContext监听
//        ①：ServletContextListener：用于对Servlet整个上下文进行监听（创建、销毁）。
//public void contextInitialized(ServletContextEvent sce);//上下文初始化
//public void contextDestroyed(ServletContextEvent sce);//上下文销毁
//
//public ServletContext getServletContext();
////ServletContextEvent事件：取得一个ServletContext（application）对象
//        ②：ServletContextAttributeListener：对Servlet上下文属性的监听（增删改属性）。
//public void attributeAdded(ServletContextAttributeEvent scab);//增加属性
//public void attributeRemoved(ServletContextAttributeEvent scab);//属性删除
//public void attributeRepalced(ServletContextAttributeEvent scab);//属性替换（第二次设置同一属性）
//
////ServletContextAttributeEvent事件：能取得设置属性的名称与内容
//public String getName();//得到属性名称
//public Object getValue();//取得属性的值


//        2.Session监听
//        ①：HttpSessionListener接口：对Session的整体状态的监听。
//public void sessionCreated(HttpSessionEvent se);//session创建
//public void sessionDestroyed(HttpSessionEvent se);//session销毁
//
////HttpSessionEvent事件：
//public HttpSession getSession();//取得当前操作的session
//        ②：HttpSessionAttributeListener接口：对session的属性监听。
//public void attributeAdded(HttpSessionBindingEvent se);//增加属性
//public void attributeRemoved(HttpSessionBindingEvent se);//删除属性
//public void attributeReplaced(HttpSessionBindingEvent se);//替换属性
//
////HttpSessionBindingEvent事件：
//public String getName();//取得属性的名称
//public Object getValue();//取得属性的值
//public HttpSession getSession();//取得当前的session
//        session的销毁有两种情况：
//        session超时，web.xml配置：
//<session-config>
//<session-timeout>120</session-timeout><!--session 120分钟后超时销毁-->
//</session-config>　　
//        手工使session失效
//public void invalidate();//使session失效方法。session.invalidate();


//        3、Request监听
//        ①：ServletRequestListener：用于对Request请求进行监听（创建、销毁）。
//public void requestInitialized(ServletRequestEvent sre);//request初始化
//public void requestDestroyed(ServletRequestEvent sre);//request销毁
//
////ServletRequestEvent事件：
//public ServletRequest getServletRequest();//取得一个ServletRequest对象
//public ServletContext getServletContext();//取得一个ServletContext（application）对象
//        ②：ServletRequestAttributeListener：对Request属性的监听（增删改属性）。
//public void attributeAdded(ServletRequestAttributeEvent srae);//增加属性
//public void attributeRemoved(ServletRequestAttributeEvent srae);//属性删除
//public void attributeReplaced(ServletRequestAttributeEvent srae);//属性替换（第二次设置同一属性）
//
////ServletRequestAttributeEvent事件：能取得设置属性的名称与内容
//public String getName();//得到属性名称
//public Object getValue();//取得属性的值
