package de.dc.spring.fx.ui.jregis.metro.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("de.dc.spring.fx.ui.jregis.metro.ui.*")
@EntityScan("de.dc.spring.fx.ui.jregis.metro.ui.*")   

public class MetroWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetroWebApplication.class, args);
    }

}