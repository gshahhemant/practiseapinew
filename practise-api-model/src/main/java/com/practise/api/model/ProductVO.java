package com.practise.api.model;

import java.util.HashSet;
import java.util.Set;

public class ProductVO {

	private long productId;

	private String name;

	private Set<ItemVO> item = new HashSet<ItemVO>();

	public ProductVO() {

	}
	
	
	public ProductVO(long productId, String name, Set<ItemVO> item) {
		
		this.productId = productId;
		this.name = name;
		this.item = item;
	}

	public ProductVO(long productId, String name) {
		
		this.productId = productId;
		this.name = name;
		
	}


	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ItemVO> getItem() {
		return item;
	}

	public void setItem(Set<ItemVO> item) {
		this.item = item;
	}

}
