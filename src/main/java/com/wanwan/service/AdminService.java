package com.wanwan.service;

import com.wanwan.domain.Admin;
import com.wanwan.domain.Employee;

import java.util.List;
import java.util.Map;

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

    /**
     * 登录
     * @param username,password
     * @return
     */
    Admin login(String username,String password) throws Exception;


    int addEmployee(Employee employee);

    Employee getEmployee();
}
