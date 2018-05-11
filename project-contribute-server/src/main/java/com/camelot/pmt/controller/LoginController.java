package com.camelot.pmt.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.shiro.jwt.JwtToken;
import com.camelot.pmt.utils.TokenUtil;

import io.swagger.annotations.Api;

@Api(description = "登陆认证")
@RestController
public class LoginController {

    @Autowired
    private TokenUtil tokenUtil;

    // @Autowired
    // private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody SysUser sysUser, HttpServletRequest request,
                                                     HttpServletResponse response, Device device) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        String username = sysUser.getUserName();
        // String password = sysUser.getPassword();

        // 验证用户名密码成功后生成token
        String token = tokenUtil.generateToken(username, device);
        // 构建JwtToken
        JwtToken jwtToken = JwtToken.builder().token(token).principal(username).build();

        Subject subject = SecurityUtils.getSubject();
        try {
            // 该方法会调用JwtRealm中的doGetAuthenticationInfo方法
            subject.login(jwtToken);
        } catch (UnknownAccountException exception) {
            exception.printStackTrace();
            System.out.println("账号不存在");
        } catch (IncorrectCredentialsException exception) {
            exception.printStackTrace();
            System.out.println("错误的凭证，用户名或密码不正确");
        } catch (LockedAccountException exception) {
            exception.printStackTrace();
            System.out.println("账户已锁定");
        } catch (ExcessiveAttemptsException exception) {
            exception.printStackTrace();
            System.out.println("错误次数过多");
        } catch (AuthenticationException exception) {
            exception.printStackTrace();
            System.out.println("认证失败");
        }

        // 认证通过
        if (subject.isAuthenticated()) {

            // 将token写出到cookie
            Cookie cookie = new Cookie("Authorization", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(3600 * 5);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.flushBuffer();

            map.put("message", "请求成功");
            map.put("token", token);
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
        } else {
            map.put("message", "请求失败");
            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.UNAUTHORIZED);

        }
    }

    /**
     * 检查是否登录
     */
    @GetMapping(value = "/checkLogin")
    public ResponseEntity<Map<String, Object>> checkLogin(@CookieValue("Authorization") String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isEmpty(token)) {
            map.put("msg", "令牌为空");
        }

        // 根据token获取用户信息

        // 检查token合法性及用户身份

        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    /**
     * 登出
     */
    @GetMapping(value = "/logout")
    public ResponseEntity<Map<String, Object>> logout(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        Optional<Cookie> cookie = Arrays.stream(request.getCookies()).filter(ck -> "Authorization".equals(ck.getName()))
                .limit(1).map(ck -> {
                    ck.setMaxAge(0);
                    ck.setHttpOnly(true);
                    ck.setPath("/");
                    return ck;
                }).findFirst();
        response.addCookie(cookie.get());
        response.flushBuffer();
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    /**
     * 更新token
     */
    @PostMapping("/token/refresh")
    public Object refreshToken(@CookieValue(value = "Authorization") String token) {
        Map<String, Object> map = new HashMap<String, Object>();
        String newToken = tokenUtil.refreshToken(token);
        map.put("code", 200);
        map.put("msg", "success");
        map.put("token", newToken);
        map.put("timestamp", Calendar.getInstance().getTimeInMillis());
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @GetMapping("/test/jwt")
    public String test() {
        String s = "s";
        return s;

    }
}
