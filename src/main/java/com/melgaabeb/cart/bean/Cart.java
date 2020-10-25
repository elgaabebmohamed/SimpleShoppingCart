package com.melgaabeb.cart.bean;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	List<Product> productList;

	public Cart() {
		super();
		this.productList = new ArrayList<>();
	}

	public Cart(List<Product> productList) {
		super();
		this.productList = productList;
	}
	
	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public void removeProduct(Long productId) {
		
		for (int i = 0; i < productList.size(); i++) {
	        if (productList.get(i).getId().equals(productId)) {
	        	productList.remove(i);
	        }
	    }
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	

}
