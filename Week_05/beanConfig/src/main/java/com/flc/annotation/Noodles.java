package com.flc.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName Noodles
 * @Description
 * @Author fanglichun
 * @Date 2020/11/21 6:12 PM
 * @Version 1.0
 **/
@Component("noodle")
public class Noodles implements Food {
    @Override
    public String desc() {
        return "面条";
    }
}
