package com.camelot.pmt.service;


import com.camelot.pmt.model.SysUser;

import java.util.List;

/**
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

    /**
     * 增加用户信息
     *
     * @param userName
     * @param realName
     * @param password
     * @param email
     * @param tel
     * @param userDesc
     * @param state
     * @return
     */
    int insert(String userName, String realName, String password, String email, String tel, String userDesc,
               Integer state);

    /**
     * 根据id更新用户信息
     *
     * @param sysUser
     * @return
     */
    int updateByPrimaryKeySelective(SysUser sysUser);

    /**
     * 查询所有用户(分页)
     *
     * @return
     */
    List<SysUser> selectAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    SysUser queryByUserName(String userName);
}
