package com.wanwan.dao;

import com.wanwan.domain.Admin;

import org.springframework.stereotype.Component;

@Component
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

   // @Select("select * from admin where id = #{id} ")
    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}