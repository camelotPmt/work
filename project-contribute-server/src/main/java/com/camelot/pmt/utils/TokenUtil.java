package com.camelot.pmt.utils;


import com.camelot.pmt.model.SysUser;
import com.camelot.pmt.service.SysUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";
    static final String CLAIM_KEY_USERID = "userId";


    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expiration}")
    private Long expiration;

    @Autowired
    private SysUserService sysUserService;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成token
     *
     * @param username 用户名
     */
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("typ", "JWT");
        header.put("alg", "HS512");
        SysUser sysUser = sysUserService.queryByUserName(username);
        claims.put(CLAIM_KEY_USERNAME, username);
        if (sysUser != null) {
            claims.put(CLAIM_KEY_USERID, sysUser.getId());
        }else{
            throw new UnknownAccountException();
        }
        //  TODO 存放角色ID
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(header, claims);
    }

    private String generateToken(Map<String, Object> header, Map<String, Object> claims) {
        return Jwts.builder().setHeader(header).setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret).compact();
    }

    /**
     * 生成token时间 = 当前时间 + expiration（properties中配置的失效时间）
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 根据token获取用户
     */
    public SysUser getUserFromToken(String token) {
        SysUser sysUser = new SysUser();
        try {
            final Claims claims = getClaimsFromToken(token);
            sysUser.setUserName(claims.getSubject());
            sysUser.setId((Integer) claims.get(CLAIM_KEY_USERID));
        } catch (Exception e) {
            sysUser = null;
        }
        return sysUser;
    }

    /**
     * 根据token获取用户名
     */
    public String getUsernameFromToken(String token) {
        String userName = "";
        try {
            final Claims claims = getClaimsFromToken(token);
            userName = (claims.getSubject());
        } catch (Exception e) {
            userName = null;
        }
        return userName;
    }

    /**
     * 判断token失效时间是否到了
     */
    @SuppressWarnings("unused")
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 获取设置的token失效时间
     */
    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    // /**
    // * Token失效校验
    // * @param token token字符串
    // * @param loginInfo 用户信息
    // * @return
    // */
    // public Boolean validateToken(String token, LoginInfo loginInfo) {
    // final String username = getUsernameFromToken(token);
    // return (
    // username.equals(loginInfo.getUsername())
    // && !isTokenExpired(token));
    // }

    public String refreshToken(String token) {
        final Claims claims = this.getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken((String) claims.get(CLAIM_KEY_USERNAME));
    }
}
