package com.aroussi.cloud.stream.commontopic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.DefaultKafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaderMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaHeaderMapperConfig {

	@Bean(name = "kafkaHeaderMapper")
	public KafkaHeaderMapper customHeaderMapper(){
		DefaultKafkaHeaderMapper mapper = new DefaultKafkaHeaderMapper();
		Map<String, Boolean> conf = new HashMap<>();
		conf.put("event_type", true);
		mapper.setRawMappedHeaders(conf);
		mapper.setCharset(StandardCharsets.UTF_8);
		return mapper;
	}

}
