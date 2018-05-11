package com.camelot.pmt.controller;


import com.camelot.pmt.model.SysDictType;
import com.camelot.pmt.model.SysDictTypeDTO;
import com.camelot.pmt.service.SysDictTypeService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: lxk
 * @CreateDate: 2018/5/9 16:49
 * @Description: 系统数据字典类型controller
 */
@RestController
@RequestMapping("/sysDictType")
public class SysDictTypeController {

    @Autowired
    SysDictTypeService sysDictTypeService;

    /**
     * 添加字典类型
     *
     * @param sysDictType 字典类型实体
     */
    @PostMapping(value = "/add")
    @ApiOperation(value = "添加字典类型", notes = "添加字典类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeCode", value = "字典类型编码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "typeName", value = "字典类型名称", required = true, paramType = "query", dataType = "String"),})
    public ResponseEntity add(@ApiIgnore SysDictType sysDictType) {
        boolean flag = sysDictTypeService.add(sysDictType);
        if (flag) {
            return ResponseEntity.ok("添加成功！");
        }
        return ResponseEntity.ok("添加失败！");
    }

    /**
     * 删除字典类型
     *
     * @param id code 字典类型id 编码
     */
    @DeleteMapping(value = "/")
    @ApiOperation(value = "删除字典类型", notes = "删除字典类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "字典类型id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "code", value = "字典类型编码", required = true, paramType = "query", dataType = "String"),})
    public ResponseEntity delete(Integer id, String code) {
        boolean flag = sysDictTypeService.delete(id, code);
        if (flag) {
            return ResponseEntity.ok("删除成功");
        }
        return ResponseEntity.ok("删除失败！");
    }

    /**
     * 编辑字典类型
     *
     * @param sysDictType 字典类型实体
     */
    @PostMapping("/update")
    @ApiOperation(value = "编辑字典类型", notes = "编辑字典类型")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "字典类型id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "typeCode", value = "字典类型编码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "typeName", value = "字典类型名称", paramType = "query", dataType = "String"),})
    public ResponseEntity update(@ApiIgnore SysDictType sysDictType) {
        boolean flag = sysDictTypeService.update(sysDictType);
        if (flag) {
            return ResponseEntity.ok("修改成功");
        }
        return ResponseEntity.ok("修改失败");
    }

    /**
     * 查询单个字典类型
     *
     * @param id 字典类型id
     */
    @GetMapping("/sys-dict-type")
    @ApiOperation(value = "查询单个字典类型", notes = "查询单个字典类型")
    @ApiImplicitParam(name = "id", value = "字典类型id", required = true, paramType = "query", dataType = "int")
    public ResponseEntity get(Integer id) {
        SysDictType sysDictType = sysDictTypeService.get(id);
        return ResponseEntity.ok(sysDictType);
    }

    /**
     * 分页条件查询字典类型编码
     *
     * @param sysDictTypeVO 字典业务
     */
    @PostMapping("/list")
    @ApiOperation(value = "分页条件查询字典类型列表", notes = "分页条件查询字典类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "typeCode", value = "字典类型编码", required = false, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "typeName", value = "字典类型名称", required = false, paramType = "query", dataType = "String"),})
    public ResponseEntity list(@ApiIgnore SysDictTypeDTO sysDictTypeVO) {
        PageInfo sysDictTypeList = sysDictTypeService.list(sysDictTypeVO);
        return ResponseEntity.ok(sysDictTypeList);
    }

    /**
     * 日期属性编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        // true允许为空
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
