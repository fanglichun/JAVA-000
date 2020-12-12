package com.flc.ssxa.service;

import com.flc.ssxa.domain.Order;

public interface IOrderService {

    /**
     * try.
     *
     * @param order order
     * @return order id
     */
    long save(Order order);

    /**
     * find order by id.
     *
     * @param id order id
     * @return order
     */
    Order findOrderById(long id);

}
