package com.camelot.pmt.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.camelot.pmt.model.SysUser;

public interface SysUserMapper {

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
     * @param createTime
     * @param createBy
     * @param updateBy
     * @param updateTime
     * @return
     */
    int insert(@Param("userName") String userName, //
            @Param("realName") String realName, //
            @Param("password") String password, //
            @Param("email") String email, //
            @Param("tel") String tel, //
            @Param("userDesc") String userDesc, //
            @Param("state") Integer state, //
            @Param("createBy") Integer createBy, //
            @Param("createTime") Date createTime, //
            @Param("updateBy") Integer updateBy, //
            @Param("updateTime") Date updateTime);

    /**
     * @mbggenerated
     */
    int insertSelective(SysUser record);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    SysUser selectByPrimaryKey(Integer id);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * @mbggenerated
     */
    int updateByPrimaryKey(SysUser record);
}