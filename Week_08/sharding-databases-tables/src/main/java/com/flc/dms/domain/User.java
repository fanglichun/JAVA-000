package com.flc.dms.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:30
 * @desc
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;

    private int userId;

    private String userName;

    private String pwd;

    @Override
    public String toString() {
        return String.format("user_id: %d, user_name: %s, pwd: %s", userId, userName, pwd);
    }
}
