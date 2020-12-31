package com.practise.api.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item  {

	
	@Id
	@SequenceGenerator(name="item_seq", sequenceName="itemsequence" , initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="item_seq")
	@Column(name = "id")
	private long itemId;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "product_id" )
	private Product product = new Product();;

	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
