package com.wanwan.service;

import com.wanwan.domain.Admin;

/**
 * Created by wanwan on 16/9/12.
 */
public interface AdminService {

    Admin selectByPrimaryKey(Integer id);


    /**
     * 修改
     * @param record
     * @return
     */

    int updateByPrimaryKeySelective(Admin record);

    int deleteByPrimaryKey(Integer id);

}