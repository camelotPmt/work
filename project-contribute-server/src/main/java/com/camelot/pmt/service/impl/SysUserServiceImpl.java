package com.camelot.pmt.service.impl;

import com.camelot.pmt.mapper.SysUserMapper;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaodj
 * @date 2018年5月10日
 */
@Service
public class SysUserServiceImpl implements SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;

  /**
   * 根据id查询用户
   */
  @Override
  public SysUser selectByPrimaryKey(Integer id) {
    return sysUserMapper.selectByPrimaryKey(id);
  }

  /**
   * 根据id删除用户
   */
  @Override
  public int deleteByPrimaryKey(Integer id) {
    return sysUserMapper.deleteByPrimaryKey(id);
  }
}
