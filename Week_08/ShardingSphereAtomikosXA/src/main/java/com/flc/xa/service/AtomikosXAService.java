package com.flc.xa.service;

import com.flc.xa.domain.Order;
import com.flc.xa.mapper.OrderMapper;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/10 14:11
 * @desc
 */
@Service
public class AtomikosXAService {

    @Resource
    private OrderMapper orderMapper;

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void addOrders() throws SQLException {
       createOrders();
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public void addSameOrders() throws SQLException {
        createOrders();
    }

    private void createOrders() throws SQLException {
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setOrderId(543800 + i);
            order.setUserId(8 + i);
            order.setAddressId(8 + i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
        }
    }
}
