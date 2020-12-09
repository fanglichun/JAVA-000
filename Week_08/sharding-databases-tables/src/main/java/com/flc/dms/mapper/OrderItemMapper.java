package com.flc.dms.mapper;

import com.flc.dms.domain.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:39
 * @desc
 */
@Mapper
public interface OrderItemMapper extends CommonRepository<OrderItem,Long> {
}
