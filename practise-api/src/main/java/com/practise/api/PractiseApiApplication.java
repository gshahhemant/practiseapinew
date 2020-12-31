package com.practise.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages= "com.practise.api")
@EnableSwagger2
@SpringBootApplication
public class PractiseApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PractiseApiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return configureApplication(builder);
	}

	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
		return builder.sources(PractiseApiApplication.class);
	}
}
