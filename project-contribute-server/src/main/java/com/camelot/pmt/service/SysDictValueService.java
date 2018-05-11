package com.camelot.pmt.service;


import com.camelot.pmt.model.SysDictTypeDTO;
import com.camelot.pmt.model.SysDictValue;
import com.github.pagehelper.PageInfo;

/**
 * @Author: gcp
 * @CreateDate: 2018/5/11 9:33
 * @Description: 数据字典类型service接口
 */
public interface SysDictValueService {

    boolean add(SysDictValue sysDictValue);

    boolean delete(Integer id, String code);

    boolean update(SysDictValue sysDictValue);

}
