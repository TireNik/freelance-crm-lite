package com.kika.customerservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public NewTopic customerEventTopic() {
        return TopicBuilder.name("customer-event")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
