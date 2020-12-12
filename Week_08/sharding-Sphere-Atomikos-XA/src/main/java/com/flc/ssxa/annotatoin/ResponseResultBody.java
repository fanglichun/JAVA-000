package com.flc.ssxa.annotatoin;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @creator fanglc@anchnet.com
 * @createdTime 2020/12/12 14:26
 * @desc
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {

}
