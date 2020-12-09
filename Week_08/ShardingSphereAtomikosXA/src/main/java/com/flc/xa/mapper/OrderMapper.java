package com.flc.xa.mapper;

import com.flc.xa.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:40
 * @desc
 */
@Mapper
public interface OrderMapper extends CommonRepository<Order, Long> {
}
