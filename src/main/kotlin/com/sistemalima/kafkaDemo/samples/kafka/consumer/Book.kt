package com.sistemalima.kafkaDemo.samples.kafka.consumer

import java.math.BigDecimal

data class Book(
    private val id: String,
    private val title: String,
    private val description: String,
    private val price: BigDecimal
)