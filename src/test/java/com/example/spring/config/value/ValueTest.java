package com.example.spring.config.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties properties;


    @Autowired
    private TestApplication.SystemProperties systemProperties;


    @Test
    void testSystemProperties() {
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-17", systemProperties.getJavaHome());
    }

    @Test
    void testValue() {
        Assertions.assertEquals("belajar-spring-config-properties", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        @Getter
        public static class SystemProperties{

            @Value("${JAVA_HOME}")
            private String javaHome;
        }

        @Component
        @Getter
        public static class ApplicationProperties {

            @Value("${spring.application.name}")
            private String name;

            @Value("${spring.application.version}")
            private Integer version;

            @Value("${spring.application.production-mode}")
            private boolean productionMode;
        }

    }
}
