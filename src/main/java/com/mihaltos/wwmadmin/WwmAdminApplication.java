package com.mihaltos.wwmadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class WwmAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(WwmAdminApplication.class, args);
    }

}
