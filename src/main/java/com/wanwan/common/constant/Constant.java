package com.wanwan.common.constant;



import com.wanwan.service.SysPriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * 静态变量
 *
 * @author wanwan
 * @create 2016-12-14 上午10:27
 */
public class Constant {

    //freetalk 平台收取比例
    public static  BigDecimal MU_YAN_FREETALK_PERCENT = new BigDecimal(0.0);
    // freetalk 老师获取的百分比
    public static  BigDecimal TEACHER_FREETALK_PERCENT = new BigDecimal(1.0);
    // 上课 平台收取费用比例
    public static  BigDecimal MU_YAN_COURSE_PERCENT = new BigDecimal(0.0);
    // 上课 授权老师收取费用比例
    public static  BigDecimal TEACHER_AUTH_COURSE_PERCENT = new BigDecimal(0.1);
    // 上课 授权老师如果是平台 获取比例
    public static  BigDecimal MU_YAN_AUTH_COURSE_PERCENT =  new BigDecimal(0.0);



}
