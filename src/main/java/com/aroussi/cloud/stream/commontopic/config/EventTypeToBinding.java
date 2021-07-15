package com.aroussi.cloud.stream.commontopic.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * match an "event_type" header to its corresponding binding channel
 */
@Getter
@RequiredArgsConstructor
public enum EventTypeToBinding {
	ORDER("orderConsumer-in-0"),
	MENU("menuConsumer-in-0");

	private final String binding;
}
