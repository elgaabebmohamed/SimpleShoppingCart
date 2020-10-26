package com.melgaabeb.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.melgaabeb.cart.bean.Product;
import com.melgaabeb.cart.manager.CartManager;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CartManagerTest {
	
	private CartManager cartManager;
	
	@BeforeAll
	public void setUp() {
		cartManager = new CartManager();
	}

	@Test
	public void WhenProductAddedThenItShouldBeRetainedInTheCart() {
		
		Product product = new Product(1L);
		cartManager.addProduct(product);
		
		List<Product> producstList = cartManager.getCart().getProducts().get(1L);
		
		assertEquals(cartManager.getCart().getProducts().keySet().size(), 1);
		assertEquals(producstList.size(), 1);
	}
	
	@Test
	public void WhenProductIsRemoavedThenItShouldBeDeletedFromTheCart() {
		
		Product productOne = new Product(1L);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L);
		cartManager.addProduct(productTwo);
		
		cartManager.removeOneItemOfProduct(productOne.getId());
		
		assertEquals(cartManager.getCart().getProducts().get(1L).size() , 0);
		assertEquals(cartManager.getCart().getProducts().get(2L).size() , 1);
	}
	
	@Test
	public void WhenGetProductCountIsCalledThenItShouldReturnProductsCountOnTheCart() {
		
		Product productOne = new Product(1L);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L);
		cartManager.addProduct(productTwo);
		
		assertEquals(cartManager.getProductsCount() , 2);

	}
	
}

