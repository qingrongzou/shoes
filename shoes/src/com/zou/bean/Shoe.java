package com.zou.bean;

public class Shoe {
	private int shoe_id;
	private double shoe_size;
	private String shoe_type;
	private double shoe_price;
	public int getShoe_id() {
		return shoe_id;
	}
	public void setShoe_id(int shoe_id) {
		this.shoe_id = shoe_id;
	}
	public double getShoe_size() {
		return shoe_size;
	}
	public void setShoe_size(double shoe_size) {
		this.shoe_size = shoe_size;
	}
	public String getShoe_type() {
		return shoe_type;
	}
	public void setShoe_type(String shoe_type) {
		this.shoe_type = shoe_type;
	}
	public double getShoe_price() {
		return shoe_price;
	}
	public void setShoe_price(double shoe_price) {
		this.shoe_price = shoe_price;
	}
	public Shoe(int shoe_id, double shoe_size, String shoe_type, double shoe_price) {
		super();
		this.shoe_id = shoe_id;
		this.shoe_size = shoe_size;
		this.shoe_type = shoe_type;
		this.shoe_price = shoe_price;
	}
	public Shoe() {
		super();
		// TODO Auto-generated constructor stub
	}
}
