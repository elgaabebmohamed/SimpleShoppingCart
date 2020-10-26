package com.melgaabeb.cart.manager;

import java.util.List;

import com.melgaabeb.cart.bean.Cart;
import com.melgaabeb.cart.bean.Product;

public interface CartManager {

	void addProduct(Product product);

	void removeOneItemOfProduct(Long productId);

	Integer getProductsCount();

	Integer getProductsCount(Long productId);

	Cart getCart();

	Double getTotalPrice();

	List<Product> fetchProducts();

}