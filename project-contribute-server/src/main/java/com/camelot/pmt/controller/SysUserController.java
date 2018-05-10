package com.camelot.pmt.controller;

import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author qiaodj
 * @date 2018年5月10日
 */
@RestController
@RequestMapping("/sysUser")
@Api(description = "用户服务")
public class SysUserController {

    private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/selectByPrimaryKey")
    @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
    public ResponseEntity<SysUser> selectByPrimaryKey(@ApiParam(value = "id", required = true) @RequestParam Integer id)
            throws Exception {
        logger.info("id={}", id);
        if (id == null) {
            throw new Exception();
        }
        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        if (sysUser != null) {
            return ResponseEntity.ok(sysUser);
        }
        throw new Exception();
    }


    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    @DeleteMapping("/deleteByPrimaryKey")
    @ApiOperation(value = "根据id删除用户", notes = "根据id删除用户")
    public ResponseEntity<?> deleteByPrimaryKey(@ApiParam(value = "id", required = true) @RequestParam Integer id)
            throws Exception {
        logger.info("id={}", id);
        if (id == null) {
            throw new Exception();
        }
        int num = sysUserService.deleteByPrimaryKey(id);
        if (num > 0) {
            return ResponseEntity.ok("删除成功");
        }
        throw new Exception();
    }

    /**
     * 增加用户信息
     *
     * @param userName
     * @param realName
     * @param password
     * @param email
     * @param tel
     * @param userDesc
     * @param state
     * @return
     * @throws Exception
     */
    @PostMapping("/insert")
    @ApiOperation(value = "增加用户信息", notes = "增加用户信息")
    public ResponseEntity<?> insert(
            @ApiParam(value = "用户名", required = true) @RequestParam String userName,
            @ApiParam(value = "真实名", required = false) @RequestParam String realName,
            @ApiParam(value = "密码", required = true) @RequestParam String password,
            @ApiParam(value = "电子邮件", required = false) @RequestParam String email,
            @ApiParam(value = "电话", required = false) @RequestParam String tel,
            @ApiParam(value = "描述/备注", required = false) @RequestParam String userDesc,
            @ApiParam(value = "状态值", required = true) @RequestParam Integer state)
            throws Exception {
        logger.info("userName={},realName={},password={},email={},tel={},userDesc={},state={}", userName, realName,
                password, email, tel, userDesc, state);
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(password) || state == null) {
            throw new Exception();
        }
        int num = sysUserService.insert(userName, realName, password, email, tel, userDesc, state);
        if (num > 0) {
            return ResponseEntity.ok("添加成功");
        }
        throw new Exception();
    }

}