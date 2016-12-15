package com.wanwan.controller;

import com.wanwan.common.jsonview.JsonView;
import com.wanwan.domain.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/log")
    public ModelAndView getLog(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        Admin admin = (Admin) request.getSession().getAttribute("user");
        Jedis jedis = new Jedis("localhost");
        List<String> list =  jedis.lrange("log-"+admin.getId(),0 ,-1);
        StringBuffer stringBuffer = new StringBuffer();
        for (String ss: list) {
            stringBuffer.append(ss);
        }
        mv.setViewName("/log");
        mv.addObject("log",stringBuffer);
        return mv ;
    }
}
