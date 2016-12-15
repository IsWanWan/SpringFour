package com.wanwan.common.interceptor;

import com.wanwan.domain.Admin;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
        System.out.println("请求地址:" + request.getRequestURI()+"::: "+ request.getRequestURL() +" 请求IP:"+request.getRemoteAddr());
        Admin admin = (Admin) request.getSession().getAttribute("user");
        if(admin ==null){
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
          return false;
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Jedis jedis = new Jedis("localhost");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("=======================================================================\n");
            stringBuffer.append("用户名/日期/终端ip:\t" + admin.getUsername() + " / " + sdf.format(new Date()) + " / " + request.getRemoteAddr() + "\n");
            String uri = request.getRequestURI();
            stringBuffer.append("地址:\t" + uri + "\n");
            stringBuffer.append("请求头:\t" + "os=" + request.getHeader("os") + ",phoneModel=" + request.getHeader("phoneModel") + ",userType=" + request.getHeader("userType") + ",language_env=" + request.getHeader("language_env") + ",timeZone=" + request.getHeader("timeZone"));

            stringBuffer.append("\n参数:\t");
            for (Map.Entry<String, String[]> param : request.getParameterMap().entrySet()) {

                stringBuffer.append(param.getKey() + "=" + StringUtils.join(param.getValue()) + ",");
            }
            stringBuffer.append("\njson:\t");
            char[] json = new char[512];
            int n;
            BufferedReader bufferedReader = request.getReader();
            while ((n = bufferedReader.read(json)) != -1) {
                stringBuffer.append(String.valueOf(json, 0, n));
            }
            jedis.rpush("log-" + admin.getId(), stringBuffer.toString());

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
