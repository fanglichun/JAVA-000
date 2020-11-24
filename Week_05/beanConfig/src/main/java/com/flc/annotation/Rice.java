package com.flc.annotation;

import org.springframework.stereotype.Component;

/**
 * @ClassName Rice
 * @Description
 * @Author fanglichun
 * @Date 2020/11/21 6:11 PM
 * @Version 1.0
 **/
@Component("rice")
public class Rice implements Food {
    @Override
    public String desc() {
        return "米饭";
    }
}
