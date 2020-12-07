package com.flc.dms.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:29
 * @desc
 */
@Data
public class ShadowUser implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;

    private int userId;

    private String userName;

    private String userNamePlain;

    private String pwd;

    private String assistedQueryPwd;

    private boolean shadow;

    @Override
    public String toString() {
        return String.format("user_id: %d, user_name: %s, user_name_plain: %s, pwd: %s, assisted_query_pwd: %s, shadow: %s", userId, userName, userNamePlain, pwd, assistedQueryPwd, shadow);
    }
}
