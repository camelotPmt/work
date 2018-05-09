package com.camelot.pmt.mapper;


import com.camelot.pmt.model.SysResource;

public interface SysResourceMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysResource record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysResource record);

    /**
     *
     * @mbggenerated
     */
    SysResource selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysResource record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysResource record);
}