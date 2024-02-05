package com.javacosmos.dependencyinjection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class BeanScopes {
  @Bean
  // @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
  // Or @Scope("singleton")
  // Annotation not necessary, as it's the default scope.
  public Object singletonBean() {
    // Only one instance of the bean is created, and it's shared by all the
    // application contexts.
    return new Object();
  }

  @Bean
  @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  // Or @Scope("prototype")
  public Object prototypeBean() {
    // A new instance of the bean is created each time it's requested.
    return new Object();
  }

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
  // The proxyMode attribute is necessary because at the moment of the
  // instantiation of the web application context,
  // Or @Scope("request")
  // Or @RequestScope
  public Object requestBean() {
    // A new instance of the bean is created for each HTTP request.
    return new Object();
  }

  @Bean
  @Scope(WebApplicationContext.SCOPE_SESSION)
  // Or @Scope("session")
  // Or @SessionScope
  public Object sessionBean() {
    // A new instance of the bean is created for each HTTP session.
    return new Object();
  }

  @Bean
  @Scope(WebApplicationContext.SCOPE_APPLICATION)
  // Or @Scope("application")
  // Or @ApplicationScope
  public Object applicationBean() {
    // A new instance of the bean is created for each ServletContext.
    // This scope is used for scenarios where you want to maintain a single instance
    // across all requests but want to isolate that instance from instances in other
    // applications running concurrently.
    return new Object();
  }

  @Bean
  @Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
  public Object websocketBean() {
    // A new instance of the bean is created for each WebSocket session.
    return new Object();
  }

  @Bean
  @Scope("globalSession")
  public Object globalSessionBean() {
    // Used in a Portlet context.
    // A new instance of the bean is created for each global HTTP session.
    return new Object();
  }
}
