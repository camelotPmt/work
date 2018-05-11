package com.camelot.pmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camelot.pmt.mapper.SysRoleMapper;
import com.camelot.pmt.model.SysRole;
import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysRoleService;

/**
 * 系统角色
 *
 * @author zlh
 * @date 2018/5/10 9:18
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 添加角色
     *
     * @param sysRole SysRole
     * @return boolean
     */
    @Override
    public boolean insertSysRole(SysRole sysRole) {

        // 获取当前登录人
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }
        sysRole.setCreatedBy(user.getId());
        sysRole.setUpdatedBy(user.getId());
        int insert = sysRoleMapper.insert(sysRole);
        if (insert == 1) {
            // 添加日志
            return true;
        }
        return false;
    }

    /**
     * 删除角色
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean deleteById(Integer id) {
        int delete = sysRoleMapper.deleteByID(id);
        if (delete == 1) {
            // 添加日志
            return true;
        }
        return false;
    }

    /**
     * 根据id修改角色
     *
     * @param sysRole SysRole
     * @return boolean
     */
    @Override
    public boolean updateById(SysRole sysRole) {
        // 获取当前登录人
        SysUser user = new SysUser();
        user.setId(1);
        if (user == null && user.getId() == null) {
            throw new RuntimeException("未获取到当前登录人");
        }
        sysRole.setUpdatedBy(user.getId());
        int update = sysRoleMapper.updateByIdSelective(sysRole);
        if (update == 1) {
            // 添加日志
            return true;
        }
        return false;
    }

    /**
     * 根据id查看详情
     *
     * @param id
     * @return SysRole
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public SysRole selectById(Integer id) {
        return sysRoleMapper.selectById(id);
    }

    /**
     * 查询所有角色
     *
     * @return SysRole
     */
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<SysRole> selectAll() {
        return sysRoleMapper.selectAll();
    }
}
