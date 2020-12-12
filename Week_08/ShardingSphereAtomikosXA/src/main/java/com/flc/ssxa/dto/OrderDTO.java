package com.flc.ssxa.dto;

import lombok.Data;

/**
 * OrderDTO
 *
 * @author zhongjinhui
 */
@Data
public class OrderDTO {
    private Long goodsId;
    private Integer quantity;
    private Long orderId;
}
