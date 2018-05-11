package com.camelot.pmt.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camelot.pmt.mapper.SysDictValueMapper;
import com.camelot.pmt.model.SysDictValue;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysDictValueService;

@Service
public class SysDictValueServiceImpl implements SysDictValueService {

    @Autowired
    SysDictValueMapper sysDictValueMapper;

    @Override
    public boolean add(SysDictValue sysDictValue) {
        // 获取当前登录人 需要获取用户信息
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }
        if (sysDictValue.getTypeCode() == null) {
            throw new IllegalArgumentException("字典类型编码不为空");
        }
        sysDictValue.setCreateBy(user.getId());
        sysDictValue.setUpdateBy(user.getId());
        sysDictValue.setState(1);
        sysDictValue.setCreateTime(new Date());
        sysDictValue.setUpdateTime(new Date());
        int result = sysDictValueMapper.insert(sysDictValue);
        if (result == 1) {
            // 日志
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id, String code) {
        // 修改此类型下所有字典值
        // 修改此编码下所有字典值类型
        int result = sysDictValueMapper.updateStateByPrimaryKey(id);

        if (result == 1) {
            // 日志
            return true;
        }
        return false;
    }

    @Override
    public boolean update(SysDictValue sysDictValue) {
        // 获取当前登录人
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }

        sysDictValue.setUpdateBy(user.getId());
        sysDictValue.setUpdateTime(new Date());
        int result = sysDictValueMapper.updateByPrimaryKeySelective(sysDictValue);
        if (result == 1) {
            // 日志
            return true;
        }
        return false;
    }
}
