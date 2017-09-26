package com.wanwan.serviceImpl;

import com.wanwan.dao.LogMapper;
import com.wanwan.domain.Log;
import com.wanwan.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by c_zhangyayun-001 on 2017/9/22.
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;
    @Override
    public int insertSelective(Log record) {
        int  i = logMapper.insertSelective(record);
        return i;
    }
}
