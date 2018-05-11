package com.camelot.pmt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysResource {

    /**
     * id
     */
    private Integer id;

    /**
     * 父ID
     */
    private Integer parentId;

    /**
     * 资源名称
     */
    private String text;

    /**
     * 资源路径
     */
    private String href;

    /**
     * 图标
     */
    private String iconcls;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * 权限标示
     */
    private String permission;

    /**
     * 排序
     */
    private Integer sortNo;

    /**
     * 显示标示 0-不显示 1-显示
     */
    private Integer isShow;

    /**
     * 状态值 0-无效 1-有效
     */
    private Integer state;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateBy;

    /**
     * 修改时间
     */
    private Date updateTime;

}