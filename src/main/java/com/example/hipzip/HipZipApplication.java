package com.example.hipzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
public class HipZipApplication {

    public static void main(String[] args) {
        SpringApplication.run(HipZipApplication.class, args);
    }

}
