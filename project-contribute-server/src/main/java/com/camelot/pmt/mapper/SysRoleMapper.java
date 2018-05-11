package com.camelot.pmt.mapper;

import java.util.List;

import com.camelot.pmt.model.SysRole;

public interface SysRoleMapper {

    /**
     * 添加角色
     *
     * @param sysRole
     *            SysRole
     * @return int
     */
    int insert(SysRole sysRole);

    /**
     * 根据id删除角色
     *
     * @param id
     *            id
     * @return int
     */
    int deleteByID(Integer id);

    /**
     * 根据id修改角色
     *
     * @param sysRole
     *            SysRole
     * @return int
     */
    int updateByIdSelective(SysRole sysRole);

    /**
     * 根据id查看角色详情
     *
     * @param id
     *            id
     * @return SysRole
     */
    SysRole selectById(Integer id);

    /**
     * 查看所有角色
     *
     * @return SysRole
     */
    List<SysRole> selectAll();

}