package com.example.spring.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ConfigurationProperties("application")
@Getter
@Setter
public class ApplicationProperties {

    private Date expiredDate;
    private Duration defaultTimeout;
    private String name;
    private Integer version;
    private boolean productionMode;
    private DatabaseProperties database;
    private List<Role> defaultRoles;
    private Map<String, Role> roles;

    @Getter
    @Setter
    public static class Role{
        private String id;
        private String name;
    }


    @Getter
    @Setter
    public static class DatabaseProperties {
        private String url;
        private String username;
        private String database;
        private String password;

        private List<String> whiteListTables;
        private Map<String, Integer> maxTablesSize;

    }


}
