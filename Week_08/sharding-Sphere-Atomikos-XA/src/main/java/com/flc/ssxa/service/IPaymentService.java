package com.flc.ssxa.service;


import com.flc.ssxa.dto.OrderDTO;

/**
 * this is payment service.
 *
 * @author zhongjinhui
 */
public interface IPaymentService {

    /**
     * payment.
     *
     * @param orderDTO {@linkplain OrderDTO}
     * @return order id
     */
    long payment(OrderDTO orderDTO);

    /**
     * payment.
     *
     * @param orderDTO {@linkplain OrderDTO}
     * @return order id
     */
    long paymentWithBuyException(OrderDTO orderDTO);

    /**
     * payment.
     *
     * @param orderDTO {@linkplain OrderDTO}
     * @return order id
     */
    long paymentWithException(OrderDTO orderDTO);

}
