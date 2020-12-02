package com.flc.dms.annotation;

import java.lang.annotation.*;

/**
 * @creator fanglc@anch.net
 * @createdTime 2020/12/2 18:44
 * @desc
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
