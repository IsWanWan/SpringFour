package com.wanwan.dao;

import com.wanwan.common.mybatis.MybatisMapper;
import com.wanwan.domain.Admin;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AdminMapper  {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

   // @Select("select * from admin where id = #{id} ")
    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 登录
     * @param map
     * @return
     */
    Admin login(Map map);

    List<Admin> listPageAdmins(Map<String,Object> map);
}