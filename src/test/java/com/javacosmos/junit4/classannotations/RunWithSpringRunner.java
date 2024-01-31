package com.javacosmos.junit4.classannotations;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * SpringRunner is an alias for the class SpringJUnit4ClassRunner and works with JUnit4-based test classes.
 * 
 * Annotation needed to enable Spring Boot features like @Autowire, @MockBean, etc... during JUnit testing.
 */

@RunWith(SpringRunner.class)
public class RunWithSpringRunner {
}
