package com.transports.transport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class TransportApplication {

    public static void main(String[] args) {SpringApplication.run(TransportApplication.class, args);}

}
