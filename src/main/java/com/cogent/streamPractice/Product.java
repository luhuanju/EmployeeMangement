package com.cogent.streamPractice;

public class Product {
	int id;
	String name;
	float cost;
	boolean available;
	
	public Product(int id, String name, float cost, Boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.available = available;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", discount=" + ", available=" + available
				+ ", sold=" + "]";
	}

}
