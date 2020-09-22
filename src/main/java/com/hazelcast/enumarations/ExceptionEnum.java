package com.hazelcast.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
	
	NO_CONTENT(1, "No Content"),
	NOT_FOUND(2, "Not Found"),
	INTERNAL_SERVER_ERROR(3, "Internal Server Error, Contact Us"),
	BAD_REQUEST(4, "Invalid Token"),
	REQUEST_TIMEOUT(5, "Request Timeout"),
	NOT_ACCEPTABLE(6, "Not Acceptable"),
	PROTHEUS_INTEGRATION(7, "Protheus Integration Error");
	
	Integer id;
	String description;

}
