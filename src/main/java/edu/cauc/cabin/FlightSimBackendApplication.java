package edu.cauc.cabin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.cauc.cabin.mapper")
public class FlightSimBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSimBackendApplication.class, args);
    }

}
