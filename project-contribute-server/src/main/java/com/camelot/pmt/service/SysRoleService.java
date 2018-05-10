package com.camelot.pmt.service;

import com.camelot.pmt.model.SysRole;

import java.util.List;

/**
 * 系统角色
 *
 * @author zlh
 * @date 2018/5/10 9:17
 */
public interface SysRoleService {

    /**
     * 添加角色
     *
     * @param sysRole
     *            SysRole
     * @return boolean
     */
    boolean insertSysRole(SysRole sysRole);

    /**
     * 删除角色
     * 
     * @param id
     *            id
     * @return boolean
     */
    boolean deleteById(Integer id);

    /**
     * 根据id修改角色
     *
     * @param sysRole
     *            SysRole
     * @return boolean
     */
    boolean updateById(SysRole sysRole);

    /**
     * 根据id查看详情
     *
     * @param id
     * @return SysRole
     */
    SysRole selectById(Integer id);

    /**
     * 查询所有角色
     *
     * @return SysRole
     */
    List<SysRole> selectAll();
}
