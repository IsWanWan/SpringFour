package com.wanwan.serviceImpl;

import com.wanwan.dao.SysPriceMapper;
import com.wanwan.domain.SysPrice;
import com.wanwan.service.SysPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * 系统价格表
 *
 * @author wanwan
 * @create 2016-12-14 上午10:46
 */
@Service
@Transactional
public class SysPriceServiceImpl implements SysPriceService {
    @Autowired
    private SysPriceMapper sysPriceMapper;
    /***
     * 根据type 查询
     *
     * @param type
     * @return
     */
    @Override
    public BigDecimal selectByType(Integer type) {
        return sysPriceMapper.selectByType(type);
    }
}
