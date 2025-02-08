package com.example.spring.config.springbootmessagesource;

import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootTest(classes = SpringMessageSourceTest.TestApplication.class)
public class SpringMessageSourceTest {

    @Autowired
    private TestApplication.SampleSource sampleSource;

    @Test
    void testHello() throws Exception {
        Assertions.assertEquals("Hello Yossia", sampleSource.getText(Locale.ENGLISH));
        Assertions.assertEquals("Halo Yossia", sampleSource.getText(new Locale("in_ID")));
    }

    @SpringBootApplication
    public static class TestApplication{

        @Component
        public static class SampleSource implements MessageSourceAware {

            @Setter
            private MessageSource messageSource;

            public String getText(Locale locale) throws Exception {
               return messageSource.getMessage("hello", new Object[]{"Yossia"}, locale);
            }
        }

    }
}
