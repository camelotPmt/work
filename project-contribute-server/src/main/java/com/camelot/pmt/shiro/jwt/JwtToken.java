package com.camelot.pmt.shiro.jwt;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements AuthenticationToken {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String principal;

    private String token;

    private String password;

    @Override
    public String getPrincipal() {
        return principal;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
