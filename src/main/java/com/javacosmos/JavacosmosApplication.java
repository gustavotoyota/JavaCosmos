package com.javacosmos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan with their default attributes.
 */

@SpringBootApplication
// Try commenting out the @SpringBootApplication annotation and uncommenting the
// following three annotations to see what happens:
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan

// The @EnableAspectJAutoProxy annotation is used to enable support for AOP
// annotations.
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class JavacosmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavacosmosApplication.class, args);
	}

}
