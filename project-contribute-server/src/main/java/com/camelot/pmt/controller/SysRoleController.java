package com.camelot.pmt.controller;


import com.camelot.pmt.model.SysRole;
import com.camelot.pmt.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 角色
 *
 * @author zlh
 * @date 2018/5/10 10:06
 */

@RestController
@RequestMapping(value = "/SysRole")
@Api(value = "角色管理接口", description = "角色管理接口")
public class SysRoleController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysRoleService sysRoleService;

    @PostMapping(value = "/insert")
    @ApiOperation(value = "添加角色", notes = "添加角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, paramType = "form",
                    dataType = "string"),
            @ApiImplicitParam(name = "roleDesc", value = "角色描述", required = true, paramType = "form",
                    dataType = "string"),
            @ApiImplicitParam(name = "state", value = "角色状态", required = true, paramType = "form",
                    dataType = "Integer")
        })
    public ResponseEntity insert(@ApiIgnore SysRole sysRole) {
        boolean result = sysRoleService.insertSysRole(sysRole);
        if (result) {
            return ResponseEntity.ok("添加角色成功");
        }
        return ResponseEntity.ok("添加角色失败");
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "query", dataType = "Integer")
        })
    public ResponseEntity delete(Integer id) {
        boolean result = sysRoleService.deleteById(id);
        if (result) {
            return ResponseEntity.ok("删除角色成功");
        }
        return ResponseEntity.ok("删除角色失败");
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, paramType = "query",
                    dataType = "string"),
            @ApiImplicitParam(name = "roleDesc", value = "角色描述", required = true, paramType = "query",
                    dataType = "string"),
            @ApiImplicitParam(name = "state", value = "角色状态", required = true, paramType = "query",
                    dataType = "Integer")
        })
    public ResponseEntity update(@ApiIgnore SysRole sysRole) {
        boolean result = sysRoleService.updateById(sysRole);
        if (result) {
            return ResponseEntity.ok("修改角色成功");
        }
        return ResponseEntity.ok("修改角色失败");
    }

    @GetMapping(value = "/selectById")
    @ApiOperation(value = "查看角色详情", notes = "查看角色详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色id", required = true, paramType = "query", dataType = "Integer")
        })
    public ResponseEntity selectById(Integer id) {
        SysRole sysRole = sysRoleService.selectById(id);
        return ResponseEntity.ok(sysRole);
    }

    @GetMapping(value = "/selectAll")
    @ApiOperation(value = "查看所有角色", notes = "查看所有角色")
    public ResponseEntity selectAll() {
        List<SysRole> sysRoles = sysRoleService.selectAll();
        return ResponseEntity.ok(sysRoles);
    }
}
