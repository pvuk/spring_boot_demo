package com.spring.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	
//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
//
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
////		config.setAllowedOrigins(allowedOrigins);
//		config.addAllowedOrigin("*");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("POST");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("DELETE");
//		config.addAllowedMethod("OPTIONS");
//		config.addAllowedMethod("PATCH");
//		config.addAllowedHeader("AUTHORIZATION");
//		config.addAllowedHeader("X-Requested-With");
//		config.addAllowedHeader("X-Auth-Token");
//		config.addAllowedHeader("X-CLIENT-ID");
//		config.addAllowedHeader("X-CLIENT_SECRET");
//		config.addAllowedHeader("Content-Type");
//		config.addExposedHeader("ETag");
//		config.addAllowedHeader("If-Match");
//		config.setMaxAge(Long.valueOf("3600"));
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", config);
//		final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
//		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		return bean;
//	}
}
