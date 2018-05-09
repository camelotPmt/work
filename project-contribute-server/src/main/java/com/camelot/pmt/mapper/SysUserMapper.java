package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysUser;

public interface SysUserMapper {
    /**
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int insert(SysUser record);

    /**
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     * @mbggenerated
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);
}