package com.camelot.pmt.service.impl;

import com.camelot.pmt.mapper.SysDictTypeMapper;
import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.service.SysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {
    @Resource
    SysDictTypeMapper sysDictTypeMapper;
    @Override
    public Integer add(SysDictType sysDictType) {
        sysDictType.setCreateTime(new Date());
        sysDictType.setUpdateTime(new Date());
        return sysDictTypeMapper.insert(sysDictType);
    }

    @Override
    public Integer delete(Integer id, String code) {
        //删除此类型下所有字典值

        return sysDictTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(SysDictType sysDictType) {
        return sysDictTypeMapper.updateByPrimaryKeySelective(sysDictType);
    }

    @Override
    public SysDictType get(Integer id) {
        return sysDictTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysDictType> list(SysDictType sysDictType) {
        return sysDictTypeMapper.selectSelective(sysDictType);
    }
}
