package com.hazelcast.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderTypeSearchEnum {
	
	PROTHEUS(1L, "Codigo Protheus"),
	ECOMMERCE(2L, "Codigo Ecommerce"),
	DOCUMENT(3L, "Documento"),
	DELIVERY(4L, "Entrega"),
	PACKAGE(5L, "Pacote");
	
	Long id;
	String description;

}
