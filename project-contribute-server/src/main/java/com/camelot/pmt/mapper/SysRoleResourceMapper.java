package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysRoleResource;

public interface SysRoleResourceMapper {

  /**
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int insert(SysRoleResource record);

  /**
   * @mbggenerated
   */
  int insertSelective(SysRoleResource record);

  /**
   * @mbggenerated
   */
  SysRoleResource selectByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(SysRoleResource record);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKey(SysRoleResource record);
}