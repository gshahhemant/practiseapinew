package com.practise.api.model;

public class ItemVO {

	private long itemId;
	private String name;

	public ItemVO() {
	
	}
	
	
	public ItemVO(long itemId, String name) {
	
		this.itemId = itemId;
		this.name = name;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
