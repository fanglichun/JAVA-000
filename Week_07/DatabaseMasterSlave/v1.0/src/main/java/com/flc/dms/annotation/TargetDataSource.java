package com.flc.dms.annotation;

import com.flc.dms.enums.DataSourceKey;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceKey value() default DataSourceKey.master;
}
