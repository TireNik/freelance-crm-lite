package com.kika.customerservice.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kika.customerservice.dto.CustomerCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendCustomerCreatedEvent(Long customerId) {
        String topic = "customer-events";

        var event = new CustomerCreatedEvent(customerId, "Новый клиент создан");

        try{
            String payload = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(topic ,payload);
            log.info("Сообщение отправлено в топик {}, с сообщением {} ", topic, payload);
        } catch (JsonProcessingException e) {
            log.error("Ошибка сериализации события для Kafka: customerId={}", customerId, e);
        } catch (Exception e) {
            log.error("Ошибка отправки в Kafka: customerId={}", customerId, e);
        }

    }
}
