package com.camelot.pmt.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camelot.pmt.mapper.SysUserMapper;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import com.camelot.pmt.utils.MD5Util;
import com.github.pagehelper.PageHelper;

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
        // MD5加盐加密
        String mD5SaltGeneratePassword = MD5Util.saltGenerate(password, userName);
        // 创建人修改人应从session中获取暂留
        return sysUserMapper.insert(userName, realName, mD5SaltGeneratePassword, email, tel, userDesc, state, 1,
                new Date(), 1, new Date());
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

    /**
     * 查询所有用户(分页)
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<SysUser> selectAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum == null || pageNum == 0 ? 1 : pageNum,
                pageSize == null || pageSize == 0 ? 10 : pageSize);
        List<SysUser> list = sysUserMapper.selectAll();
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public SysUser queryByUserName(String userName) {
        return sysUserMapper.queryByUserName(userName);
    }
}
