package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysGroup;

public interface SysGroupMapper {

  /**
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int insert(SysGroup record);

  /**
   * @mbggenerated
   */
  int insertSelective(SysGroup record);

  /**
   * @mbggenerated
   */
  SysGroup selectByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(SysGroup record);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKey(SysGroup record);
}