package com.camelot.pmt.mapper;


import com.camelot.pmt.model.LogUserLogin;

public interface LogUserLoginMapper {
    /**
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int insert(LogUserLogin record);

    /**
     * @mbggenerated
     */
    int insertSelective(LogUserLogin record);

    /**
     * @mbggenerated
     */
    LogUserLogin selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LogUserLogin record);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKey(LogUserLogin record);
}