package com.example.spring.config.profileenvironment;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = ProfileEnvironmentTest.TestApplication.class)
@ActiveProfiles({"local", "production"})
public class ProfileEnvironmentTest {

    @Autowired
    private TestApplication.SampleProfile sampleProfile;

    @Test
    void testActiveProfiles() {
        Assertions.assertArrayEquals(new String[]{"local", "production"}, sampleProfile.getProfiles());
    }

    @SpringBootApplication
    static class TestApplication {

        @Setter
        @Component
        abstract static class SampleProfile implements EnvironmentAware{

            private Environment environment;

            public String[] getProfiles(){
                return environment.getActiveProfiles();
            }


        }
    }
}
