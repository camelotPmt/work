package com.camelot.pmt.controller;


import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
 * @author qiaodj
 * @date 2018年5月10日
 */
@Slf4j
@RestController
@RequestMapping("/sys-user")
@Api(description = "用户服务")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据id查询用户
     */
    @GetMapping("/by-id")
    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query",
                    dataType = "int")})
    public ResponseEntity<?> selectByPrimaryKey(@ApiIgnore SysUser sysUser) {
        log.info("id={}", sysUser.getId());
        sysUser = sysUserService.selectByPrimaryKey(sysUser.getId());
        if (sysUser != null) {
            return ResponseEntity.ok(sysUser);
        } else {
            return ResponseEntity.ok("查询失败");
        }
    }

    /**
     * 根据id删除用户
     */
    @DeleteMapping("/by-id")
    @ApiOperation(value = "根据id删除用户", notes = "根据id删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query",
                    dataType = "int")})
    public ResponseEntity<?> deleteByPrimaryKey(@ApiIgnore SysUser sysUser) {
        log.info("id={}", sysUser.getId());
        int num = sysUserService.deleteByPrimaryKey(sysUser.getId());
        if (num > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.ok("删除失败");
        }
    }

    /**
     * 增加用户信息
     */
    @PostMapping("/add")
    @ApiOperation(value = "增加用户信息", notes = "增加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "realName", value = "真实名", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "email", value = "电子邮件", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "tel", value = "电话", required = false, paramType = "query",
                    dataType = "String"),
            @ApiImplicitParam(name = "userDesc", value = "描述/备注", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "state", value = "状态值", required = true, paramType =
                    "query", dataType = "int"),})
    public ResponseEntity<?> insert(@ApiIgnore SysUser sysUser) {
        log.info("userName={},realName={},password={},email={},tel={},userDesc={},state={}",
                sysUser.getUserName(),
                sysUser.getRealName(), sysUser.getPassword(), sysUser.getEmail(), sysUser.getTel(),
                sysUser.getUserDesc(), sysUser.getState());
        int num = sysUserService
                .insert(sysUser.getUserName(), sysUser.getRealName(), sysUser.getPassword(),
                        sysUser.getEmail(), sysUser.getTel(), sysUser.getUserDesc(),
                        sysUser.getState());
        if (num > 0) {
            return ResponseEntity.ok("添加成功");
        } else {
            return ResponseEntity.ok("添加失败");
        }
    }

    /**
     * 根据id更新用户信息
     */
    @PutMapping("/by-id")
    @ApiOperation(value = "根据id更新用户信息", notes = "根据id更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "query",
                    dataType = "int"),
            @ApiImplicitParam(name = "realName", value = "真实名", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "email", value = "电子邮件", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "tel", value = "电话", required = false, paramType = "query",
                    dataType = "String"),
            @ApiImplicitParam(name = "userDesc", value = "描述/备注", required = false, paramType =
                    "query", dataType =
                    "String"),
            @ApiImplicitParam(name = "state", value = "状态值", required = false, paramType =
                    "query", dataType = "int"),})
    public ResponseEntity<?> updateByPrimaryKeySelective(@ApiIgnore SysUser sysUser) {
        log.info("realName={},password={},email={},tel={},userDesc={},state={}",
                sysUser.getRealName(),
                sysUser.getPassword(), sysUser.getEmail(), sysUser.getTel(), sysUser.getUserDesc(),
                sysUser.getState());
        int num = sysUserService.updateByPrimaryKeySelective(sysUser);
        if (num > 0) {
            return ResponseEntity.ok("更新成功");
        } else {
            return ResponseEntity.ok("更新失败");
        }
    }

    /**
     * 查询所有用户(分页)
     */
    @GetMapping("/by-page")
    @ApiOperation(value = "查询所有用户(分页)", notes = "查询所有用户(分页)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页数", required = true, paramType =
                    "query", dataType =
                    "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, paramType =
                    "query", dataType =
                    "int")})
    public ResponseEntity<?> selectAllByPage(@ApiIgnore PageInfo<?> pageInfo) {
        log.info("pageNum={},pageSize={}", pageInfo.getPageNum(), pageInfo.getPageSize());
        List<SysUser> list = sysUserService
                .selectAllByPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        if (list.size() > 0) {
            return ResponseEntity.ok(list);
        } else {
            return ResponseEntity.ok("查询失败");
        }
    }
}