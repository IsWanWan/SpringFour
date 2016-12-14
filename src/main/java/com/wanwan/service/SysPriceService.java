package com.wanwan.service;

import java.math.BigDecimal;

/**
 * Created by wanwan on 2016/12/14.
 */
public interface SysPriceService {
    /***
     * 根据type 查询
     * @param type
     * @return
     */
    BigDecimal selectByType(Integer type) ;
}
