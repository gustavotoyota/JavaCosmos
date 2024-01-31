package com.javacosmos.classannotations;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

/*
 * WebMvcTest is used for Spring MVC tests. It auto-configures the following features:
 * - Activates Spring Data JPA repositories
 * - Configures Spring MVC and REST controllers
 * - Turns on appropriate Spring MVC @ControllerAdvice's
 * - Turns on appropriate Spring MVC @JsonComponent's
 * - Auto-configures MockMvc
 * - Auto-configures Spring Security
 * - Only scans @Component, @Controller, @ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, HandlerInterceptor, WebMvcConfigurer, and HandlerMethodArgumentResolver beans
 */

@WebMvcTest
public class WebMvcTestAnnotation {

}
