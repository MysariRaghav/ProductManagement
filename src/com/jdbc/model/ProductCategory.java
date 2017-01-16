package com.jdbc.model;

public class ProductCategory extends Category{
	
	private String product_code/*, product_category*/;

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	@Override
	public String toString() {
		return "ProductCategory [product_code=" + product_code /*+ ", product_category=" + product_category + "]"*/;
	}
	
	

}
