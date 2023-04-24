package com.sistemalima.kafkaDemo.samples.kafka.consumer

import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class BookConsumer {

    private val logger = LoggerFactory.getLogger(BookConsumer::class.java)

    @KafkaListener(topics = ["\${spring.kafka.consumer.topic}"], groupId = "\${spring.kafka.consumer.group-id}")
    fun listen(@Payload event: BookEvent) {

        logger.info("Inicio do consumer do kafka")

        val book = event.toModel()

        logger.info("Fim do consumo do kafka, book: $book")

    }
}