package com.imooc.user.response;

import lombok.Data;

/**
 * Created by Michael on 2017/10/30.
 */
@Data
public class LoginResponse extends Response {

    private String token;

    public LoginResponse(String token) {
        super();
        this.token = token;
    }

}
