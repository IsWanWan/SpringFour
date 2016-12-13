package com.wanwan.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * spring 定时任务
 *
 * @author wanwan
 * @create 2016-11-09 下午5:07
 */
@Component
public class Task {

    @Scheduled(cron = "0 0 1 * * ?" ) //每天凌晨 1点执行
         public void rankingByScoreJob() {
                 System.out.println("通过spring-task，每天凌晨1点执行。。。" +new Date());
                 System.out.println("----------------------------------------");
         //        userDao.rankingByScore();
            }
//    @Scheduled(fixedRate = 1000 * 60) // 一分钟执行一次
//    public void  taskTwo(){
//        System.out.println(" ====== 定时任务2 :======= 一分钟执行一次" + new Date());
//    }
}
