package com.wanwan.serviceImpl;

import com.wanwan.dao.AdminMapper;
import com.wanwan.dao.EmployeeMapper;
import com.wanwan.domain.Admin;
import com.wanwan.domain.Employee;
import com.wanwan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanwan on 16/9/12.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

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


    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 登录
     *
     * @param  username, password
     * @return
     */
    @Override
    public Admin login(String username,String password) throws Exception {
        Map map = new HashMap();
        map.put("username",username);
        map.put("password",password);
        return adminMapper.login(map);
    }

    @Override
    public int addEmployee(Employee employee) {
       int n = employeeMapper.insertSelective(employee);
        return n;
    }

    @Override
    public Employee getEmployee() {
        return employeeMapper.selectByPrimaryKey(1003);
    }


}
