package com.syousui.mildintegratedmanagesystem.interceptor;

import com.syousui.mildintegratedmanagesystem.utils.WebUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : TouSan
 * @version : 1.0.0
 * @ClassName : RoleInterceptor.java
 * @PackageLocation : com.syousui.mildintegratedmanagesystem.interceptor
 * @Email : acmaker@foxmail.com
 * @createTime : 2020-11-24 10:21:00 星期二
 * @Description : TODO
 */

public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle ( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        boolean isAccess = true;
        String url = request.getRequestURI( );
        if ( url.contains("/User") ) {
            isAccess = WebUtil.fetchUser( ).getRole( ) > 0;
        }
        response.getWriter().println( "Please login first and be sure you are administrator." );
        return isAccess;
    }
    @Override
    public void postHandle ( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {

    }
    @Override
    public void afterCompletion ( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception {

    }
}
