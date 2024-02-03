package com.javacosmos.kafka;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
  private KafkaProducer kafkaProducer;

  public KafkaController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @PostMapping("/kafka/produce/{topic}")
  public void send(@PathVariable String topic, @RequestBody String message) {
    this.kafkaProducer.send(topic, message);
  }
}
