package com.wanwan.dao;

import com.wanwan.domain.LogLogin;

import org.springframework.stereotype.Repository;

@Repository
public interface LogLoginMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogLogin record);

    int insertSelective(LogLogin record);

    LogLogin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LogLogin record);

    int updateByPrimaryKeyWithBLOBs(LogLogin record);

    int updateByPrimaryKey(LogLogin record);
}