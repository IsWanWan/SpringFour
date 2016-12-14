package com.wanwan.common.interceptor;

import com.wanwan.domain.Admin;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring mvc 拦截器
 *
 * @author wanwan
 * @create 2016-12-14 下午4:37
 */
public class CommonInterceptor  extends HandlerInterceptorAdapter {
    public CommonInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // return super.preHandle(request, response, handler);
      Admin admin = (Admin) request.getSession().getAttribute("user");
        if(admin ==null){
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
          return false;
        }else{
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
