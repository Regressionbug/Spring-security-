package com.sangeng.jwt;

/**
 * @author Lixuhang
 * @date 2023/4/10
 * @whatItFor
 */
public class JwtObject {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtObject(String token) {
        this.token = token;
    }
}
