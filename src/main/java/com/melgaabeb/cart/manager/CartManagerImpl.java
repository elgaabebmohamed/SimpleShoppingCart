package com.melgaabeb.cart.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.melgaabeb.cart.bean.Cart;
import com.melgaabeb.cart.bean.Product;

public class CartManagerImpl implements CartManager {
	
	private Cart cart;

	public CartManagerImpl() {
		super();
		this.cart = new Cart();
	}

	public CartManagerImpl(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@Override
	public void addProduct(Product product) {
		Map<Long, List<Product>> products = cart.getProducts();
		
		if (products.containsKey(product.getId())) {
			products.get(product.getId()).add(product);
		} else {
			products.put(product.getId(), new ArrayList<>(Arrays.asList(product)));
		}
	}
	
	@Override
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
	public Integer getProductsCount() {
		return cart.getProducts().values().stream().mapToInt(List::size).sum();
	}
	
	@Override
	public Integer getProductsCount(Long productId) {
		Integer result = 0;
		if (cart.getProducts().containsKey(productId)) {
			List<Product> productList = cart.getProducts().get(productId);
			if (productList != null && !productList.isEmpty()) {
				result = productList.size();
			}
		}
		return result;
	}
	
	@Override
	public Double getTotalPrice() {
		
		Double cartSum = 0.0;
		for (Entry<Long, List<Product>> entry : cart.getProducts().entrySet()) {
			Double productSum = entry.getValue().stream().mapToDouble(Product::getPrice).sum();
			cartSum += productSum;
		}
		return cartSum;
	}
	
	@Override
	public List<Product> fetchProducts() {
		List<Product> productList = new ArrayList<>();
		for (Entry<Long, List<Product>> entry : cart.getProducts().entrySet()) {
			productList.addAll(entry.getValue());
		}
		return productList;
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
		CartManagerImpl other = (CartManagerImpl) obj;
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
