package com.hazelcast.enumarations;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author robson
 *
 */

@Getter
@AllArgsConstructor
public enum FileTypeEnum {
	
	SIGNATURE(1, "SIGNATURE"),
	DOCUMENT(2, "DOCUMENT");
	
	Integer id;
	String description;

}
