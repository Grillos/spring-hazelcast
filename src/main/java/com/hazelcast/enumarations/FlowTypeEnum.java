package com.hazelcast.enumarations;

public enum FlowTypeEnum {

	READY("Ready"), 
	PICKUP("Pickup"), 
	REVERSED("Reversed");
	
	private String description;

	FlowTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
