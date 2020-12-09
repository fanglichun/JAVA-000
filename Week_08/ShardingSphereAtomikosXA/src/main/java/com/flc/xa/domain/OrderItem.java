package com.flc.xa.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:27
 * @desc
 */
@Data
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;

    private long orderItemId;

    private long orderId;

    private int userId;

    private String status;

    @Override
    public String toString() {
        return String.format("order_item_id:%s, order_id: %s, user_id: %s, status: %s", orderItemId, orderId, userId, status);
    }
}
