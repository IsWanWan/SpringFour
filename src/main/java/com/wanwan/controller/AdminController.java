package com.wanwan.controller;

import com.alibaba.fastjson.JSON;
import com.wanwan.common.constant.Constant;
import com.wanwan.common.jsonview.JsonView;
import com.wanwan.common.util.RedisCacheStorage;
import com.wanwan.common.util.RedisCacheStorageImpl;
import com.wanwan.domain.Admin;
import com.wanwan.domain.LogLogin;
import com.wanwan.service.AdminService;
import com.wanwan.service.LogLoginService;
import com.wanwan.service.SysPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanwan on 16/9/12.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
 public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
  @Autowired
  private AdminService adminService;
    @Autowired
    private LogLoginService logLoginService;
    @Autowired
    private SysPriceService sysPriceService;
    /**
     * 缓存存储
     */
     @Autowired
    private RedisCacheStorageImpl<Admin> storageCache;
    private String cacheKey = "admin";
    /***
     * 测试
     * @return
     */

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        Admin admin = adminService.selectByPrimaryKey(1);
        mv.addObject(admin);

        storageCache.hset(cacheKey,String.valueOf(admin.getId()),admin);
        Admin adminO = JSON.parseObject(storageCache.hget(cacheKey,String.valueOf(admin.getId())),Admin.class) ;
        System.out.println(" get from admin::::::"+adminO.getUsername());
        logger.info("测试::::::::::::::::"+adminO.getUsername());
        mv.setViewName("/test");
        return mv;
    }

    /***
     * 登录接口
     * @return
     */
    @RequestMapping("/login")
    public JsonView Login(HttpSession session,String username,String password) {
        Map map = new HashMap();
        try {
            Admin admin = adminService.login(username, password);
            if (admin != null) {
                session.setAttribute("user",admin);
                return new JsonView(200, "登录成功");

            } else {
                return new JsonView(300, "用户名或密码错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("登录错误");
            return new JsonView(500, "系统错误");
        }


    }

}
