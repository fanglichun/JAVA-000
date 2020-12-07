package com.flc.dms.mapper;

import com.flc.dms.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:40
 * @desc
 */
@Mapper
public interface OrderRepository  extends CommonRepository<Order, Long> {
}
