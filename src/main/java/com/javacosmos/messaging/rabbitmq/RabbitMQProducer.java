package com.javacosmos.messaging.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
  private RabbitTemplate rabbitTemplate;

  public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void send(String queue, String message) {
    this.rabbitTemplate.convertAndSend(queue, message);
  }
}
