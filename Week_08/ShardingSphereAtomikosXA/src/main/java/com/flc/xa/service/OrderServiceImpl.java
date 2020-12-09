package com.flc.xa.service;


import com.flc.xa.domain.Address;
import com.flc.xa.domain.Order;
import com.flc.xa.domain.OrderItem;
import com.flc.xa.mapper.AddressMapper;
import com.flc.xa.mapper.OrderItemMapper;
import com.flc.xa.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 15:58
 * @desc
 */
@Service
@Primary
@Slf4j
public class OrderServiceImpl implements ShardingSphereService{

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    @Resource
    private AddressMapper addressMapper;

    @Override
    public void initEnvironment() throws SQLException {
        orderMapper.createTableIfNotExists();
        orderItemMapper.createTableIfNotExists();
        orderMapper.truncateTable();
        orderItemMapper.truncateTable();
        initAddressTable();
    }

    private void initAddressTable() throws SQLException {
        addressMapper.createTableIfNotExists();
        addressMapper.truncateTable();
        for (int i = 1; i <= 10; i++) {
            Address entity = new Address();
            entity.setAddressId((long) i);
            entity.setAddressName("address_" + i);
            addressMapper.insert(entity);
        }
    }

    @Override
    public void cleanEnvironment() throws SQLException {
//        orderMapper.dropTable();
//        orderItemMapper.dropTable();
    }

    @Override
    @Transactional
    public void processSuccess() throws SQLException {
        log.info("-------------- Process Success Begin ---------------");
        List<Long> orderIds = insertData();
        printData();
        deleteData(orderIds);
        printData();
        log.info("-------------- Process Success Finish --------------");
    }

    @Override
    @Transactional
    public void processFailure() throws SQLException {
        log.info("-------------- Process Failure Begin ---------------");
        insertData();
        log.info("-------------- Process Failure Finish --------------");
        throw new RuntimeException("Exception occur for transaction test.");
    }

    public List<Long> insertData() throws SQLException {
        log.info("---------------------------- Insert Data ----------------------------");
        List<Long> result = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setAddressId(i);
            order.setStatus("INSERT_TEST");
            orderMapper.insert(order);
            OrderItem item = new OrderItem();
            item.setOrderId(order.getOrderId());
            item.setUserId(i);
            item.setStatus("INSERT_TEST");
            orderItemMapper.insert(item);
            result.add(order.getOrderId());
        }
        return result;
    }

    public void deleteData(final List<Long> orderIds) throws SQLException {
        log.info("---------------------------- Delete Data ----------------------------");
        for (Long each : orderIds) {
//            orderMapper.delete(each);
//            orderItemMapper.delete(each);
        }
    }

    @Override
    public void printData() throws SQLException {
        log.info("---------------------------- Print Order Data -----------------------");
        for (Order order : orderMapper.selectAll()) {
            log.info(order.toString());
        }
        log.info("---------------------------- Print OrderItem Data -------------------");
        for (OrderItem orderItem : orderItemMapper.selectAll()) {
            log.info(orderItem.toString());
        }
    }
}
