package com.flc.ssxa.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.flc.ssxa.domain.Goods;
import com.flc.ssxa.domain.Order;
import com.flc.ssxa.dto.GoodsStockDTO;
import com.flc.ssxa.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * PaymentServiceImpl
 *
 * @author zhongjinhui
 */
@Slf4j
@Service
public class PaymentServiceImpl implements IPaymentService {

    private final Snowflake ID = IdUtil.getSnowflake(1, 1);

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IOrderService orderService;

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public long payment(OrderDTO orderDTO) {
        Goods goods = goodsService.selectById(orderDTO.getGoodsId());
        Order order = doCreateOrder(orderDTO, goods);
        orderService.save(order);
        orderDTO.setOrderId(order.getId());
        GoodsStockDTO goodsStockDTO = createGoodsStockDTO(orderDTO);
        goodsService.buy(goodsStockDTO);
        return order.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public long paymentWithBuyException(OrderDTO orderDTO) {
        Goods goods = goodsService.selectById(orderDTO.getGoodsId());
        Order order = doCreateOrder(orderDTO, goods);
        orderService.save(order);
        orderDTO.setOrderId(order.getId());
        GoodsStockDTO goodsStockDTO = createGoodsStockDTO(orderDTO);
        goodsService.buyException(goodsStockDTO);
        return order.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    @Override
    public long paymentWithException(OrderDTO orderDTO) {
        Goods goods = goodsService.selectById(orderDTO.getGoodsId());
        Order order = doCreateOrder(orderDTO, goods);
        orderService.save(order);
        orderDTO.setOrderId(order.getId());
        GoodsStockDTO goodsStockDTO = createGoodsStockDTO(orderDTO);
        goodsService.buy(goodsStockDTO);
        throw new IllegalStateException("---->>payment exception......");
    }

    private GoodsStockDTO createGoodsStockDTO(OrderDTO orderDTO) {
        GoodsStockDTO goodsStockDTO = new GoodsStockDTO();
        goodsStockDTO.setGoodsId(orderDTO.getGoodsId());
        goodsStockDTO.setQuantity(orderDTO.getQuantity());
        return goodsStockDTO;
    }

    private Order doCreateOrder(OrderDTO orderDTO, Goods goods) {
        Order order = new Order();
        order.setOrderSn(ID.nextIdStr());
        order.setMemberId(ID.nextId());
        order.setGoodsId(orderDTO.getGoodsId());
        order.setGoodsName(goods.getName());
        order.setPrice(goods.getPrice());
        order.setQuantity(orderDTO.getQuantity());
        order.setTotalAmount(BigDecimal.valueOf(orderDTO.getQuantity()).multiply(goods.getPrice()));
        order.setStatus(1);
        return order;
    }
}
