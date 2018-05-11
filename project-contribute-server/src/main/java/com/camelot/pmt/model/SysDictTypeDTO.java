package com.camelot.pmt.model;
/**
* @Author:       lxk
* @CreateDate:  2018/5/10 10:38
* @Description: 数据字典类型VO
*/
public class SysDictTypeDTO {
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
     * 页码
     */
    private Integer pageNum;

    /**
     * 页大小
     */
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "SysDictTypeDTO{" +
                "typeCode='" + typeCode + '\'' +
                ", typeName='" + typeName + '\'' +
                ", state=" + state +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
