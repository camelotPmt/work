package com.camelot.pmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camelot.pmt.model.SysDictValue;
import com.camelot.pmt.service.SysDictValueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Author: gcp
 * @CreateDate: 2018/5/11 9:49
 * @Description: 系统数据字典类型controller
 *
 */
@RestController
@RequestMapping("/sys-dic-value")
@Api(value = "数据字值", description = "数据字值")
public class SysDicValueController {

    @Autowired
    SysDictValueService sysDictValueService;

    /**
     * 添加字典值
     *
     * @param sysDictValue
     *            字典值实体
     */
    @PostMapping(value = "/save")
    @ApiOperation(value = "添加字典类型", notes = "添加字典类型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeCode", value = "字典类型编码", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "valueName", value = "字典值名称", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "valueCode", value = "字典值编码", required = true, paramType = "query", dataType = "String") })
    public ResponseEntity<String> save(@ApiIgnore SysDictValue sysDictValue) {
        boolean flag = sysDictValueService.add(sysDictValue);
        if (flag) {
            return ResponseEntity.ok("添加成功！");
        }
        return ResponseEntity.ok("添加失败！");
    }

    /**
     * 删除字典值
     *
     * @param id
     *            code 字典值id 编码
     */
    @DeleteMapping(value = "/")
    @ApiOperation(value = "删除字典值", notes = "删除字典值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "字典值id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "code", value = "字典值编码", required = true, paramType = "query", dataType = "String"), })
    public ResponseEntity<String> delete(Integer id, String code) {
        boolean flag = sysDictValueService.delete(id, code);
        if (flag) {
            return ResponseEntity.ok("删除成功");
        }
        return ResponseEntity.ok("删除失败！");
    }

    /**
     * 编辑字典类型
     *
     * @param sysDictValue
     *            字典类型实体
     */
    @PostMapping("/update")
    @ApiOperation(value = "编辑字典值", notes = "编辑字典值")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "字典值id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "typeCode", value = "字典类型编码", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "valueName", value = "字典名称", paramType = "query", dataType = "String") })
    public ResponseEntity<String> update(@ApiIgnore SysDictValue sysDictValue) {
        boolean flag = sysDictValueService.update(sysDictValue);
        if (flag) {
            return ResponseEntity.ok("修改成功");
        }
        return ResponseEntity.ok("修改失败");
    }
}
