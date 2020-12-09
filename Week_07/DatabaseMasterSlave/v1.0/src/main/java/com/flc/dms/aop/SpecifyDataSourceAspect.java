package com.flc.dms.aop;

import com.flc.dms.annotation.TargetDataSource;
import com.flc.dms.enums.DataSourceKey;
import com.flc.dms.configuration.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @creator fanglc@anchnet.com
 * @createdTime 2020/12/4 10:08
 * @desc 通过建立
 */
@Component
@Aspect
@Order(0)
@Slf4j
public class SpecifyDataSourceAspect {
    @Pointcut("@annotation(com.flc.dms.annotation.TargetDataSource)")
    public void dataSourcePointcut() {

    }

    @Before("dataSourcePointcut()")
    public void switchDataSource(JoinPoint joinPoint) {
        TargetDataSource targetDataSource = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(TargetDataSource.class);
        DataSourceKey dataSourceKey = targetDataSource.value();
        String name = dataSourceKey.name();
        if (DynamicDataSourceContextHolder.containDataSourceKey(name)) {
//            if (DataSourceKey.master.equals(dataSourceKey)) {
//                DynamicDataSourceContextHolder.useMasterDataSource();
//            } else {
//                DynamicDataSourceContextHolder.useSlaveDataSource();
//            }
            DynamicDataSourceContextHolder.setDataSourceKey(name);
            log.info("Switch DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
        } else {
            log.error("DataSource [{}] doesn't exist, use default DataSource [{}]", targetDataSource, targetDataSource.value());
        }
    }

    @After("dataSourcePointcut()")
    public void restoreDataSource(JoinPoint joinPoint) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
        log.info("Restore DataSource to [{}] in Method [{}]", DynamicDataSourceContextHolder.getDataSourceKey(), joinPoint.getSignature());
    }

}
