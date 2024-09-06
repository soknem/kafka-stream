package com.spring_cloud_stream.kafka_stream.kafka;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class KafkaStreamProcessor {

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> process() {
        return inputStream -> inputStream
                .filter((key, value) -> value != null && !value.isEmpty())
                .mapValues(value -> value.toUpperCase());
    }
}
