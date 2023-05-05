package com.classboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 웹뷰(Thymeleaf) static resources
		registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/static/js/");

	}
}
