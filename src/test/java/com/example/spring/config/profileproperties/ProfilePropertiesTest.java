package com.example.spring.config.profileproperties;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
@ActiveProfiles({
        "production","test"
})
public class ProfilePropertiesTest {

    @Autowired
    private TestApplication.ProfileProperties properties;

    @Test
    void nameProfilesProperties() {
        Assertions.assertEquals("Default", properties.getDefaultFileName());
        Assertions.assertEquals("Production", properties.getProductionFileName());
        Assertions.assertEquals("Test", properties.getTestFileName());
    }

    @SpringBootApplication
    static class TestApplication {

        @Getter
        @Component
        static class ProfileProperties{

            @Value("${profile.default}")
            private String defaultFileName;

            @Value("${profile.production}")
            private String productionFileName;

            @Value("${profile.test}")
            private String testFileName;

//            public String getDefaultFileName() {
//                return defaultFileName;
//            }
//            public String getProductionFileName() {
//                return productionFileName;
//            }
//            public String getTestFileName() {
//                return testFileName;
//            }

        }
    }
}
