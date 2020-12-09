package com.flc.dms.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:26
 * @desc
 */
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 661434701950670670L;

    private long orderId;

    private int userId;

    private long addressId;

    private String status;

    @Override
    public String toString() {
        return String.format("order_id: %s, user_id: %s, address_id: %s, status: %s", orderId, userId, addressId, status);
    }
}
