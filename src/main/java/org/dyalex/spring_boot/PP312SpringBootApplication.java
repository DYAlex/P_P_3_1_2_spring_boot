package org.dyalex.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PP312SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PP312SpringBootApplication.class, args);
    }

}
