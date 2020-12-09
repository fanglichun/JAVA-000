package com.flc.dms.controller;

import com.flc.dms.service.ShardingSphereService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Resource
    private ShardingSphereService shardingSphereService;

    @GetMapping
    public void run() throws SQLException {
        try {
            shardingSphereService.initEnvironment();
            shardingSphereService.processSuccess();
        } catch (SQLException e) {
            log.info("error code:[{}],error msg:[{}]", e.getErrorCode(), e.getMessage());
        } finally {
            try {
                shardingSphereService.cleanEnvironment();
            } catch (SQLException e) {
                log.info("error code:[{}],error msg:[{}]", e.getErrorCode(), e.getMessage());
            }
        }
    }

}
