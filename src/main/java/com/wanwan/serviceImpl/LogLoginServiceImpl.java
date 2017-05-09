package com.wanwan.serviceImpl;

import com.wanwan.dao.LogLoginMapper;
import com.wanwan.domain.LogLogin;
import com.wanwan.service.LogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录记录service
 *
 * @author wanwan
 * @create 2016-10-17 下午9:38
 */
@Service
public class LogLoginServiceImpl implements LogLoginService{
   @Autowired
    private LogLoginMapper logLoginMapper;

    public LogLogin selectByPrimaryKey(Long id) {

        return logLoginMapper.selectByPrimaryKey((long) 2230);
    }
}
