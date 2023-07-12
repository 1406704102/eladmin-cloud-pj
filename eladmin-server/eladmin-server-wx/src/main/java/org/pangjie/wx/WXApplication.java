package org.pangjie.wx;

import org.micah.security.annotation.EnableCustomizeFeignClient;
import org.micah.security.annotation.EnableCustomizeResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableCustomizeResourceServer
@EnableCustomizeFeignClient
@SpringBootApplication
public class WXApplication {
    public static void main(String[] args) {
        SpringApplication.run(WXApplication.class,args);
    }

}