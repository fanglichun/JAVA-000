package com.flc.ssxa.mapper;

import com.flc.ssxa.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OrderMapper {

    /**
     * save order.
     *
     * @param order order
     */
    void save(@Param("order") Order order);

    /**
     * select order by id.
     *
     * @param id order id
     * @return order
     */
    Order selectOrderById(long id);

    /**
     * delete order by id.
     *
     * @param id order id
     */
    void deleteOrderById(long id);

    /**
     * update order status by id.
     *
     * @param id order id
     */
    void updateOrderById(long id);
}
