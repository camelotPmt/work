package com.camelot.pmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDictType {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 类型code
     */
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

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