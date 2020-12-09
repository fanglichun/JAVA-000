package com.flc.xa.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:25
 * @desc
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 661434701950670670L;
    private Long addressId;
    private String addressName;

}
