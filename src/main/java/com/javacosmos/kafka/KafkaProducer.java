package com.javacosmos.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class KafkaProducer {
  private KafkaTemplate<String, String> kafkaTemplate;

  public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(@NonNull String topic, String message) {
    this.kafkaTemplate.send(topic, message);
  }
}
