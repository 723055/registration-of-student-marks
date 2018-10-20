package org.pflb.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.SQLException;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
@EnableJpaRepositories
@PropertySource(value = {"classpath:env/${env}/web.properties",
        "classpath:env/${env}/db.properties"})
public class CourseSystemApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(CourseSystemApplication.class, args);
    }

}
