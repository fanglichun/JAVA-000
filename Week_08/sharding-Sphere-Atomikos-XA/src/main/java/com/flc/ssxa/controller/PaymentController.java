package com.flc.ssxa.controller;


import com.flc.ssxa.vo.Result;
import com.flc.ssxa.dto.OrderDTO;
import com.flc.ssxa.service.IPaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class PaymentController {
    @Resource
    private IPaymentService paymentService;

    @PostMapping("payment")
    public Result payment(@RequestBody OrderDTO orderDTO) {
        return Result.success(paymentService.payment(orderDTO));
    }

    @PostMapping("paymentWithBuyException")
    public Result paymentWithBuyException(@RequestBody OrderDTO orderDTO) {
        return Result.success(paymentService.paymentWithBuyException(orderDTO));
    }

    @PostMapping("paymentWithException")
    public Result paymentWithException(@RequestBody OrderDTO orderDTO) {
        return Result.success(paymentService.paymentWithException(orderDTO));
    }

}
