package com.javacosmos.messaging.rabbitmq;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
  private RabbitMQProducer rabbitProducer;

  public RabbitMQController(RabbitMQProducer rabbitProducer) {
    this.rabbitProducer = rabbitProducer;
  }

  @PostMapping("/rabbitmq/produce/{queue}")
  public void send(@PathVariable String queue, @RequestBody String message) {
    this.rabbitProducer.send(queue, message);
  }
}
