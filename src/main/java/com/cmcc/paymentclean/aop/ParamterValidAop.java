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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Aspect
@Component
public class ParamterValidAop {

  @Autowired private MessageSourceHandler messageSourceHandler;

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
      if (obj instanceof Collection) {
        for (int i = 0; i < ((List) obj).size(); i++) {
          Set<ConstraintViolation<Object>> constraintViolations =
              validator.validate(((List) obj).get(i));
          this.addError(errors, constraintViolations);
        }
      } else {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
        this.addError(errors, constraintViolations);
      }
    }
    return errors;
  }

  private void addError(
      List<String> errors, Set<ConstraintViolation<Object>> constraintViolations) {
    for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
      if (!errors.contains(constraintViolation.getMessage())) {
        errors.add(constraintViolation.getMessage());
      }
    }
  }
}
