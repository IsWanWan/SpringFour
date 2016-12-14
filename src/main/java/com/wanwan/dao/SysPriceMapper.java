package com.wanwan.dao;

import com.wanwan.domain.SysPrice;

import java.math.BigDecimal;

public interface SysPriceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPrice record);

    int insertSelective(SysPrice record);

    SysPrice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPrice record);

    int updateByPrimaryKey(SysPrice record);

    /***
     * 根据type 查询
     * @param type
     * @return
     */
    BigDecimal  selectByType(Integer type) ;
}