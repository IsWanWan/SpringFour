package com.wanwan.controller;

import com.wanwan.domain.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 公用的controller
 *
 * @author wanwan
 * @create 2016-12-15 上午10:47
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    /**
     * 本方法 ,输出系统操作日志
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/log")
    public ModelAndView getLog(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        Admin admin = (Admin) request.getSession().getAttribute("user");
        Jedis jedis = new Jedis("localhost");
        List<String> list =  jedis.lrange("log-"+admin.getId(),0 ,-1);
        StringBuffer stringBuffer = new StringBuffer();
        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();

            for (String ss: list) {
                //stringBuffer.append(ss);
                printWriter.println(ss);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.flush();
        printWriter.close();

        mv.setViewName("/log");
      //  mv.addObject("log",stringBuffer);
        return mv ;
    }
}
