package com.sistemalima.kafkaDemo.samples.kafka.consumer

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.UUID

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@EmbeddedKafka(
    topics = ["\${spring.kafka.consumer.topic}"],
    partitions = 1,
    bootstrapServersProperty = "spring.kafka.bootstrap-servers"
)
internal class BookConsumerTest {

    @Autowired
    private lateinit var template : KafkaTemplate<String, BookEvent>

    @Autowired
    private lateinit var bookConsumer: BookConsumer

    @Value("\${spring.kafka.consumer.topic}")
    private lateinit var topico: String

    @Test
    fun `deve consumir mensagem no tópico de livros`() {
        // Dado

        val event = BookEvent(
            id = UUID.randomUUID().toString(),
            title = "Clean Code",
            description = "Code clean",
            price = BigDecimal.ONE
        )

        // Quando / Então

        assertDoesNotThrow { bookConsumer.listen(event) }
    }
}