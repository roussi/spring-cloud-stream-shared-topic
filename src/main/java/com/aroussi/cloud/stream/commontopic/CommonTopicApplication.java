package com.aroussi.cloud.stream.commontopic;

import com.aroussi.cloud.stream.commontopic.config.CustomMessageRoutingCallback;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.MessageRoutingCallback;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class CommonTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonTopicApplication.class, args);
	}

	/**
	 * {@link MessageRoutingCallback} for mapping to the appropriate
	 * binding by checking the {@link CustomMessageRoutingCallback#EVENT_TYPE}
	 * @return
	 */
	@Bean
	public MessageRoutingCallback messageRoutingCallback() {
		return new CustomMessageRoutingCallback();
	}

	@Bean
	public Consumer<Order> orderConsumer(){
		return order -> log.info(order.toString());
	}
	@Bean
	public Consumer<Menu> menuConsumer(){
		return menu -> log.info(menu.toString());
	}
}

@Data
class Order {
	private String id;
	private Double price;
}

@Data
class Menu {
	private String id;
	private String name;
}