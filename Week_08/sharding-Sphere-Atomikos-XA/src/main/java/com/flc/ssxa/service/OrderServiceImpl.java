package com.flc.ssxa.service;;
import com.flc.ssxa.domain.Order;
import com.flc.ssxa.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public long save(final Order order) {
        orderMapper.save(order);
        return order.getId();
    }

    @Override
    public Order findOrderById(final long id) {
        return orderMapper.selectOrderById(id);
    }

}
