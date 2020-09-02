package com.cmcc.paymentclean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cmcc.paymentclean.mapper")
public class PaymentCleanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentCleanApplication.class, args);
    }

}
