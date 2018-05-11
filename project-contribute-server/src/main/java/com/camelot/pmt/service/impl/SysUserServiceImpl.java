package com.camelot.pmt.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camelot.pmt.mapper.SysUserMapper;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;

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
     *
     * @param id
     * @return
     */
    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 增加用户
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
    @Override
    public int insert(String userName, String realName, String password, String email, String tel, String userDesc,
            Integer state) {
        // 创建人修改人应从session中获取暂留
        return sysUserMapper.insert(userName, realName, password, email, tel, userDesc, state, 1, new Date(), 1,
                new Date());
    }

    /**
     * 根据id更新用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
