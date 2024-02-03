package com.javacosmos.messaging.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
  @Bean
  public Queue queue1() {
    return new Queue("queue-1", false);
  }

  @Bean
  public Queue queue2() {
    return new Queue("queue-2", false);
  }
}
