package com.wanwan.serviceImpl;

import com.wanwan.dao.AdminMapper;
import com.wanwan.domain.Admin;
import com.wanwan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wanwan on 16/9/12.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    public Admin selectByPrimaryKey(Integer id) {

        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }
}
