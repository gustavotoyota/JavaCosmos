package com.javacosmos.contextconfig;

import org.springframework.test.context.ContextConfiguration;

/*
 * @ContextConfiguration is used choose custom configuration classes to be loaded into the ApplicationContext for integration tests.
 */

@ContextConfiguration(classes = { MyCustomConfig.class })
public class ContextConfigurationExample {
}
