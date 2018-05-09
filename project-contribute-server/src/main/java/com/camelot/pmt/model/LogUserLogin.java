package com.camelot.pmt.model;

import java.util.Date;

public class LogUserLogin {
    /**
     * id
     */
    private Integer id;

    /**
     * 登录用户名称
     */
    private String loginUser;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 状态值 0-无效 1-有效
     */
    private Integer state;

    /**
     * 创建人
     */
    private Integer createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private Integer updatedBy;

    /**
     * 修改时间
     */
    private Date updatedTime;

    /**
     * id
     * @return id id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录用户名称
     * @return login_user 登录用户名称
     */
    public String getLoginUser() {
        return loginUser;
    }

    /**
     * 登录用户名称
     * @param loginUser 登录用户名称
     */
    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser == null ? null : loginUser.trim();
    }

    /**
     * 登录时间
     * @return login_time 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 登录时间
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 登录IP
     * @return login_ip 登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 登录IP
     * @param loginIp 登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 状态值 0-无效 1-有效
     * @return state 状态值 0-无效 1-有效
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态值 0-无效 1-有效
     * @param state 状态值 0-无效 1-有效
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 创建人
     * @return created_by 创建人
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 创建时间
     * @return created_time 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 创建时间
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 修改人
     * @return updated_by 修改人
     */
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 修改人
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 修改时间
     * @return updated_time 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 修改时间
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}