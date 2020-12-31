package com.practise.api.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "PRODUCT")
public class Product {

	
	@Id
	@SequenceGenerator(name="product_seq", sequenceName="productsequence" , initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@Column(name = "product_id")
	private long productId;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true )
	private Set<Item> item = new HashSet<Item>();

	public Product() {

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

	public Set<Item> getItem() {
		return item;
	}

	public void setItem(Set<Item> item) {
		this.item = item;
	}

}
