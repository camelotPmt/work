package com.camelot.pmt.service;

import com.camelot.pmt.model.SysUser;

/**
 * 
 * @author qiaodj
 * @date 2018年5月10日
 */

public interface SysUserService {
    /**
     * 根据id查询用户
     * 
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * 根据id删除用户
     * 
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
}
