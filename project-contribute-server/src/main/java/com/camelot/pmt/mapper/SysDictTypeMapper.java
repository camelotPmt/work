package com.camelot.pmt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.model.SysDictTypeDTO;

@Mapper
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

    List<SysDictType> selectSelective(SysDictTypeDTO sysDictTypeVO);

    SysDictType selectByTypeCode(String typeCode);

    int updateStateByPrimaryKey(Integer id);
}