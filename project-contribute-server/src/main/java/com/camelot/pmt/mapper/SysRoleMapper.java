package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysRole;

public interface SysRoleMapper {

  /**
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int insert(SysRole record);

  /**
   * @mbggenerated
   */
  int insertSelective(SysRole record);

  /**
   * @mbggenerated
   */
  SysRole selectByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(SysRole record);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKey(SysRole record);
}