package com.camelot.pmt.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDictValue {

  /**
   * 主键ID
   */
  private Integer id;

  /**
   * 类型编码
   */
  private String typeCode;

  /**
   * 值名称
   */
  private String valueName;

  /**
   * 值编码
   */
  private String valueCode;

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