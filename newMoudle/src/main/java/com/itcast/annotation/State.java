package com.itcast.annotation;

import com.itcast.validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/22 18:33
 * @Version: 1.0
 * @Description:
 */
@Documented //元注解
@Constraint(validatedBy = {StateValidation.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface State {
//    提供校验失败后的提示信息
    String message() default "state参数的值只能是“已发布”或“草稿”";
//指定分组
    Class<?>[] groups() default {};
//负载    获取State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
