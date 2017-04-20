package com.wanwan.controller;

import com.wanwan.common.jsonview.JsonView;
import com.wanwan.common.util.RedisCacheStorageImpl;
import com.wanwan.domain.Admin;
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
        Admin admin = adminService.selectByPrimaryKey(2);

        if(admin ==null){
            logger.info("admin 不能为空!!!!!!!!!!!!!!!");
            logger.error(" admin 为空");

        }
        mv.addObject(admin);
//        storageCache.hset(cacheKey,String.valueOf(admin.getId()),admin);
//        Admin adminO = JSON.parseObject(storageCache.hget(cacheKey,String.valueOf(admin.getId())),Admin.class) ;
//        System.out.println(" get from admin::::::"+adminO.getUsername());
//        logger.info("测试::::::::::::::::"+adminO.getUsername());
        mv.setViewName("/index");
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

    @RequestMapping("/test")
    public JsonView test(){
        Admin admin = new Admin();
        admin.setUsername("hahahahah");
        return new JsonView(200, "成功",admin);
    }
    @RequestMapping("/sprintOne")
    public JsonView sprintOne(){
        Admin admin = new Admin();
        admin.setUsername("sprintOne");
        return new JsonView(200, "成功");
    }

}
