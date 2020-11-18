package com.flc.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @creator fanglc@anchnet.com
 * @createdTime 2020/11/18 16:34
 * @desc
 */
@Data
@Builder
public class User {
    private int id;
    private String code;
    private String name;
}
