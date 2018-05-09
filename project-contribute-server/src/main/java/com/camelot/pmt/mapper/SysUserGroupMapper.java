package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysUserGroup;

public interface SysUserGroupMapper {
    /**
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int insert(SysUserGroup record);

    /**
     * @mbggenerated
     */
    int insertSelective(SysUserGroup record);

    /**
     * @mbggenerated
     */
    SysUserGroup selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUserGroup record);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUserGroup record);
}