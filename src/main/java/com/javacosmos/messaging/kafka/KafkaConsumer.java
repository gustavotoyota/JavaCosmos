package com.javacosmos.messaging.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
  @KafkaListener(topics = { "topic-1", "topic-2" }, groupId = "group-1")
  public void consume(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
    System.out.println("Consumed Kafka message from topic \"" + topic + "\": " + message);
  }
}
