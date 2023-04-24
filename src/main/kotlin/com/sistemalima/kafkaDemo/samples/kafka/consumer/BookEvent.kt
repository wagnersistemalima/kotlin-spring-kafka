package com.sistemalima.kafkaDemo.samples.kafka.consumer

import java.math.BigDecimal

data class BookEvent(
    private val id: String,
    private val title: String,
    private val description: String,
    private val price: BigDecimal
) {
    fun toModel(): Book {
        return Book(
            id = this.id,
            title = this.title,
            description = this.description,
            price = this.price
        )
    }
}
