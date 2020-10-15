package com.cmcc.paymentclean.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 需要加密的字段注解
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface EncrField {
    String value() default "";
}
