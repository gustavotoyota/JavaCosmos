package com.javacosmos.messaging.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {
  @RabbitListener(queues = { "queue-1", "queue-2" })
  public void listen(String message, @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String queue) {
    System.out.println("Consumed RabbitMQ message from queue \"" + queue + "\": " + message);
  }
}
