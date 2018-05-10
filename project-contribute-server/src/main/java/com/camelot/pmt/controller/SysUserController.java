package com.camelot.pmt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * @author qiaodj
 * @date 2018年5月10日
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据id查询用户
     * 
     * @param id
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户", tags = { "sysUser-Service" })
    public ResponseEntity<SysUser> selectByPrimaryKey(
            @ApiParam(value = "id", required = true) @RequestParam Integer id) {
        logger.info("id={}", id);
        if (id == null) {
            return null;
        }
        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        if (sysUser != null) {
            return ResponseEntity.ok(sysUser);
        }
        return null;
    }

    /**
     * 根据id删除用户
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/deleteByPrimaryKey")
    @ApiOperation(value = "根据id删除用户", notes = "根据id删除用户", tags = { "sysUser-Service" })
    public ResponseEntity<?> deleteByPrimaryKey(@ApiParam(value = "id", required = true) @RequestParam Integer id) {
        logger.info("id={}", id);
        if (id == null) {
            return ResponseEntity.ok("参数id不能为空");
        }
        int num = sysUserService.deleteByPrimaryKey(id);
        if (num > 0) {
            return ResponseEntity.ok("删除成功");
        }
        return ResponseEntity.ok("此id不存在");
    }

}