package com.melgaabeb.cart.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Cart {
	
	Map<Long, List<Product>> products;
	
	public Cart() {
		super();
		this.products = new HashMap<>();
	}

	public Cart(Map<Long, List<Product>> products) {
		super();
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
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
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

	public Map<Long, List<Product>> getProducts() {
		return products;
	}

	public void setProducts(Map<Long, List<Product>> products) {
		this.products = products;
	}

}
