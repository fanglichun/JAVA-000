package com.flc.xa;

import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/10 17:25
 * @desc
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = XAOrderServiceTest.class)
@Import(TransactionConfiguration.class)
@ComponentScan(basePackages = "com.flc.xa")
@ActiveProfiles("sharding-databases-tables")
public class XAOrderServiceTest {

    @Autowired
    private XAOrderService orderService;

    @Before
    public void setUp() {
        orderService.init();
    }

    @After
    public void cleanUp() {
        orderService.cleanup();
    }

    @Test
    public void assertInsertFailed() {
        try {
            orderService.insertFailed(10);
            // CHECKSTYLE:OFF
        } catch (final Exception ignore) {
            // CHECKSTYLE:ON
        }
        assertThat(orderService.selectAll(), is(0));
    }

    @Test
    public void assertInsertSuccess() {
        assertThat(orderService.insert(20), is(TransactionType.XA));
        assertThat(orderService.selectAll(), is(20));
    }
}
