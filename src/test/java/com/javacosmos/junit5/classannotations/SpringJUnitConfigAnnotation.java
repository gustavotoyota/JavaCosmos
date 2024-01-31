package com.javacosmos.junit5.classannotations;

import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
 * SpringJUnitConfig is an alternative to SpringRunner and works with JUnit5.
 * 
 * It is a composed annotation that combines @ExtendWith(SpringExtension.class) and @ContextConfiguration.
 */

@SpringJUnitConfig
public class SpringJUnitConfigAnnotation {
}
