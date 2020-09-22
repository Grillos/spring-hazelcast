package com.hazelcast.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author robson
 *
 */

@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
	
	DELIVERED(1, "DELIVERED"),
	INTRANSIT(2, "INTRANSIT");
	
	Integer id;
	String description;

}
