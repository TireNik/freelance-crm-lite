package com.kika.customerservice.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kika.customerservice.entity.Customer;
import com.kika.customerservice.repository.CustomerRepository;
import com.kika.customerservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerEventConsumer {

    private final TaskService task;
    private final CustomerRepository customerRepo;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "customer-events", groupId = "customer-service-group")
    @Transactional
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        try {
            log.info("Получено сообщение из топика: '{}', {}.", topic, message);

            Map<String, Object> jsonMap = objectMapper.readValue(message, Map.class);
            Long customerId = Long.valueOf(jsonMap.get("customerId").toString());

            createWelcomeTask(customerId);
        } catch (JsonProcessingException e) {
            log.error("Ошибка парсинга JSON из Kafka: message={}", message, e);
            throw new IllegalArgumentException("Invalid JSON format", e);
        } catch (IllegalArgumentException e) {
            log.error("Клиент не найден: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("Непредвиденная ошибка при обработке сообщения Kafka: message={}", message, e);
            throw new RuntimeException("Failed to process Kafka message", e);
        }
    }

    @Transactional(readOnly = true)
    public void createWelcomeTask(Long customerId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        task.createdWelcomeTask(customer);
    }
}
