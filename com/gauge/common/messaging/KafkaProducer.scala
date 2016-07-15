package com.gauge.common.messaging

import java.util.Properties

import org.apache.kafka.clients.producer.{Callback, KafkaProducer => ApacheKafkaProducer, ProducerRecord, RecordMetadata}

import scalaz.concurrent.Task
import scalaz.{-\/, \/-}

class KafkaProducer extends Producer {

  override def send[K, V](key: K, content: V)(implicit config: KafkaProducerConfig): Task[Unit] = {
    val props = new Properties()
    props.put("bootstrap.servers", config.servers)
    props.put("key.serializer", config.keySerializer)
    props.put("value.serializer", config.valueSerializer)
    props.put("partitioner.class", config.partitioner)

    val producer = new ApacheKafkaProducer[K, V](props)
    val t = System.currentTimeMillis()
    val data = new ProducerRecord[K, V](config.topic, 0, t, key, content)

    //TODO: specify timeout -> load it from the app config
    Task async {
      k => producer.send(data, new Callback {
      override def onCompletion(rm: RecordMetadata, e: Exception): Unit = {
        (Option(rm), Option(e)) match {
          case (Some(_), None) => k(\/-())
          case (_, Some(e)) => k(-\/(e))
          case _ => k.apply(-\/(new RuntimeException("Unexpected result from Kafka producer callback")))
        }
      }})
    }
  }
}