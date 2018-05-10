package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysDictType;

public interface SysDictTypeMapper {

  /**
   * @mbggenerated
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int insert(SysDictType record);

  /**
   * @mbggenerated
   */
  int insertSelective(SysDictType record);

  /**
   * @mbggenerated
   */
  SysDictType selectByPrimaryKey(Integer id);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(SysDictType record);

  /**
   * @mbggenerated
   */
  int updateByPrimaryKey(SysDictType record);
}