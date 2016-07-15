package com.gauge.common.messaging

final class KafkaProducerConfig(
   val servers: String,
   val topic: String,
   val keySerializer: String,
   val valueSerializer: String,
   val partitioner: String)