package com.cmcc.paymentclean.aop;

import com.cmcc.paymentclean.exception.ParamInvalidException;
import com.cmcc.paymentclean.utils.MessageSourceHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

@Aspect
@Component
public class ParamterValidAop {

    @Autowired
    private MessageSourceHandler messageSourceHandler;

    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Before("execution(* com.cmcc.paymentclean.controller..*.*(..))")
    public void doBefore(JoinPoint point) throws ParamInvalidException {
        Object[] params = point.getArgs();

        // 校验参数是否合法
        List<String> errors = this.validate(params);
        if (errors != null && !errors.isEmpty()) {
            throw new ParamInvalidException(errors, messageSourceHandler);
        }
    }

    /**
     * 校验参数
     *
     * @param params
     * @return
     */
    private List<String> validate(Object[] params) {
        if (params == null || params.length == 0) {
            return null;
        }
        List<String> errors = new ArrayList<String>();
        for (Object obj : params) {

            if (obj == null) {
                continue;
            }

            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Object>> constraintViolations = new LinkedHashSet<>();
            if(obj instanceof Collection){
                for(int i=0;i<((List) obj).size();i++){
                    constraintViolations = validator.validate(((List) obj).get(i));
                }
            }else{
                constraintViolations = validator.validate(obj);
            }

            for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                errors.add(constraintViolation.getMessage());
            }
        }
        return errors;
    }
}
