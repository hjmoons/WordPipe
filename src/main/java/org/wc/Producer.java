package org.wc;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    private String topic;
    private KafkaProducer<String, String> kafkaProducer;

    public Producer(String topic, String bootstrap) {
        this.topic = topic;
        this.kafkaProducer = new KafkaProducer<String, String>(setProducerConfig(bootstrap));
    }

    public void send(String msg) {
        kafkaProducer.send(new ProducerRecord<>(topic, msg));
    }

    /* Kafka Producer Configure*/
    public Properties setProducerConfig(String bootstrap) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrap);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return properties;
    }
}
