package com.itcast.validation;

import com.itcast.annotation.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: Lvlingyun
 * @Date: 2024/1/22 18:43
 * @Version: 1.0
 * @Description:
 */
public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value  将来要校验的数据
     * @param context
     * @return 如果返回false，则校验不通过，返回true，则校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        提供校验规则
        if(value == null){
            return false;
        }
        if(value.equals("已发布")||value.equals("草稿")){
            return true;
        }
        return false;

    }
}
