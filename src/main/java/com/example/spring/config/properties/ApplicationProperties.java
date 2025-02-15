package com.example.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("application")
@Getter
@Setter
public class ApplicationProperties {

    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties database;


    @Getter
    @Setter
    public static class DatabaseProperties {
        private String url;
        private String username;
        private String database;
        private String password;
    }
}
