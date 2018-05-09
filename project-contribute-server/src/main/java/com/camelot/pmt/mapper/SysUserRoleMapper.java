package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysUserRole;

public interface SysUserRoleMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    SysUserRole selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUserRole record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUserRole record);
}