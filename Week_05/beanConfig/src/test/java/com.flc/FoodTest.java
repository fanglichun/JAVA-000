package com.flc;

import com.flc.annotation.Food;
import com.flc.config.FoodConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @ClassName FoodTestkClass
 * @Description
 * @Author fanglichun
 * @Date 2020/11/21 6:19 PM
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FoodConfig.class)
public class FoodTest {

    @Autowired
    @Qualifier("rice")
    private Food food;

    @Test
    public void foodNotNull() {
        assertNotNull(food);
        System.out.println(food.desc());
    }

}
