package com.jdbc.model;

public class ProductDetails {
	
	private int pid, quantity;
	
	private double price, rating; 
	
	private String product_name, product_code, discription;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public String toString() {
		return "ProductDetails [pid=" + pid + ", quantity=" + quantity + ", price=" + price + ", rating=" + rating
				+ ", product_name=" + product_name + ", product_code=" + product_code + ", discription=" + discription
				+ "]";
	}
	


}
