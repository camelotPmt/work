package com.camelot.pmt.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (id == null) {
            return null;
        }
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        if (sysUser != null) {
            return sysUser;
        }
        return null;
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        if (id == null) {
            return 0;
        }
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
    @Transactional
    public int insert(String userName, String realName, String password, String email, String tel, String userDesc,
                      Integer state) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || state == null) {
            return 0;
        }
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
    @Transactional
    public int updateByPrimaryKeySelective(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
