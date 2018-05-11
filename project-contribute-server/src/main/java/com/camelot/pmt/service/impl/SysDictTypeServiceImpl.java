package com.camelot.pmt.service.impl;

import com.camelot.pmt.mapper.SysDictTypeMapper;
import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.model.SysDictTypeDTO;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysDictTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author: lxk
 * @CreateDate: 2018/5/10 11:28
 * @Description: 数据字典类型service类
 */
@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {
    @Resource
    SysDictTypeMapper sysDictTypeMapper;

    /**
     * 添加字典类型
     *
     * @param sysDictType
     */
    @Override
    public boolean add(SysDictType sysDictType) throws IllegalArgumentException {
        // 获取当前登录人
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }
        //查询此字典码是否已经存在
        SysDictType sysDictType1 = sysDictTypeMapper.selectByTypeCode(sysDictType.getTypeCode());
        if (null != sysDictType1) {
            //此编码已经存在
            throw new IllegalArgumentException("字典类型编码已存在！");
        }
        sysDictType.setCreateBy(user.getId());
        sysDictType.setUpdateBy(user.getId());
        sysDictType.setState(1);
        sysDictType.setCreateTime(new Date());
        sysDictType.setUpdateTime(new Date());
        int result = sysDictTypeMapper.insert(sysDictType);
        if (result == 1) {
            //日志
            return true;
        }
        return false;
    }

    /**
     * 删除字典类型---逻辑删除
     *
     * @param id code
     */
    @Override
    public boolean delete(Integer id, String code) {
        //修改此类型下所有字典值
        //修改此编码下所有字典值类型
        int result = sysDictTypeMapper.updateStateByPrimaryKey(id);
        if (result == 1) {
            //日志
            return true;
        }
        return false;
    }

    /**
     * 编辑字典类型
     *
     * @param sysDictType
     */
    @Override
    public boolean update(SysDictType sysDictType) {
        // 获取当前登录人
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }
        //查询此字典码是否已经存在
        SysDictType sysDictType1 = sysDictTypeMapper.selectByTypeCode(sysDictType.getTypeCode());
        if (null != sysDictType1) {
            //此编码已经存在
            throw new IllegalArgumentException("字典类型编码已存在！");
        }
        sysDictType.setUpdateBy(user.getId());
        sysDictType.setUpdateTime(new Date());
        int result = sysDictTypeMapper.updateByPrimaryKeySelective(sysDictType);
        if (result == 1) {
            //日志
            return true;
        }
        return false;
    }

    /**
     * 查询字典类型
     *
     * @param id
     */
    @Override
    public SysDictType get(Integer id) {
        return sysDictTypeMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页条件查询字典类型
     *
     * @param sysDictSysDictTypeDTO
     * @return
     */
    @Override
    public PageInfo list(SysDictTypeDTO sysDictSysDictTypeDTO) {
        if (null == sysDictSysDictTypeDTO) {
            throw new IllegalArgumentException("请求参数异常！");
        }
        /*
         * pageHelper使用三部曲 1.启动pageHelper分页 startPage -- start 2.填充自己的sql（查询逻辑）
         * 3.pageHelper的收尾
         */
        Integer pageNum = sysDictSysDictTypeDTO.getPageNum();
        Integer pageSize = sysDictSysDictTypeDTO.getPageSize();
        // 初始化分页信息
        PageHelper.startPage(pageNum == 0 ? 1 : pageNum, pageSize == 0 ? 10 : pageSize);
        // 查询产品list
        List<SysDictType> sysDictTypeList = sysDictTypeMapper.selectSelective(sysDictSysDictTypeDTO);
        // pageHelper的收尾
        PageInfo pageResult = new PageInfo(sysDictTypeList);
        pageResult.setList(sysDictTypeList);
        return pageResult;
    }
}