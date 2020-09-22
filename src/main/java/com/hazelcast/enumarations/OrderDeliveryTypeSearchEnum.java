package com.hazelcast.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderDeliveryTypeSearchEnum {
	
	DELIVERY(4L, "Entrega");
	
	Long id;
	String description;

}
