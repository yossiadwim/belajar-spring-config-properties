package com.example.spring.config;

import com.example.spring.config.converter.StringToDateConverter;
import com.example.spring.config.properties.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;


@SpringBootApplication
@EnableConfigurationProperties({
		ApplicationProperties.class
})
@Slf4j
public class BelajarSpringConfigPropertiesApplication {

	@Bean
	public ConversionService conversionService(StringToDateConverter stringToDateConverter){
		ApplicationConversionService conversionService = new ApplicationConversionService();
		conversionService.addConverter(stringToDateConverter);
		return conversionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringConfigPropertiesApplication.class, args);
	}

}
