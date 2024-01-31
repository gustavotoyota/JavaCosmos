package com.javacosmos.junit5.classannotations;

import org.springframework.boot.test.context.SpringBootTest;

/*
 * SpringBootTest is an alternative to SpringRunner and works with JUnit5.
 * 
 * It is used to indicate that the tests should be conducted in the context of a fully configured Spring Boot application.
 * 
 * It loads the complete application context and can be used to test the integration of various components in a Spring Boot application.
 */

@SpringBootTest
public class SpringBootTestAnnotation {
}
