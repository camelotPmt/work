package com.camelot.pmt.controller;

import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaodj
 * @date 2018年5月10日
 */
@RestController
@RequestMapping("/sysUser")
@Api(description = "用户服务")
public class SysUserController {

  private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
  @Autowired
  private SysUserService sysUserService;

  /**
   * 根据id查询用户
   */
  @GetMapping("/selectByPrimaryKey")
  @ApiOperation(value = "根据id查询用户", notes = "根据id查询用户")
  public ResponseEntity<SysUser> selectByPrimaryKey(
      @ApiParam(value = "id", required = true) @RequestParam Integer id)
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
   */
  @DeleteMapping("/deleteByPrimaryKey")
  @ApiOperation(value = "根据id删除用户", notes = "根据id删除用户")
  public ResponseEntity<?> deleteByPrimaryKey(
      @ApiParam(value = "id", required = true) @RequestParam Integer id)
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

}