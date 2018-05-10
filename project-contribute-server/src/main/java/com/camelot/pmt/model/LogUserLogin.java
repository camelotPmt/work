package com.camelot.pmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}