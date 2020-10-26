package com.melgaabeb.cart.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.melgaabeb.cart.bean.Cart;
import com.melgaabeb.cart.bean.Product;

public class CartManager {
	
	private Cart cart;

	public CartManager() {
		super();
		this.cart = new Cart();
	}

	public CartManager(Cart cart) {
		super();
		this.cart = cart;
	}
	
	public void addProduct(Product product) {
		Map<Long, List<Product>> products = cart.getProducts();
		
		if (products.containsKey(product.getId())) {
			products.get(product.getId()).add(product);
		} else {
			products.put(product.getId(), new ArrayList<>(Arrays.asList(product)));
		}
	}
	
	public void removeOneItemOfProduct(Long productId) {
		Map<Long, List<Product>> products = cart.getProducts();
		
		if (products.containsKey(productId)) {
			List<Product> productList = products.get(productId);
			if (productList != null && !productList.isEmpty()) {
				productList.remove(0);
			}
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
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
		CartManager other = (CartManager) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		return true;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
