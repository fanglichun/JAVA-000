package com.flc.xa.controller;

import com.flc.xa.service.AtomikosXAService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/4 16:09
 * @desc
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private DataSource dataSource;
    @Resource
    private AtomikosXAService atomikosXAService;

    @PostMapping("/atomikosXA")
    public void run() throws SQLException {
        atomikosXAService.addOrders();
    }
}
