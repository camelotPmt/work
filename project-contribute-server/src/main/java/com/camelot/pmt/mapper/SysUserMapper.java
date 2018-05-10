package com.camelot.pmt.mapper;

import com.camelot.pmt.model.SysUser;

public interface SysUserMapper {
    /**
     * 根据id删除用户
     * 
     * @param id
     * @return
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
     * 根据id查询用户
     * 
     * @param id
     * @return
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