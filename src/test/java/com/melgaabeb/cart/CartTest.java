package com.melgaabeb.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.melgaabeb.cart.bean.Cart;
import com.melgaabeb.cart.bean.Product;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CartTest {
	
	private Cart cart;
	
	@BeforeAll
	public void setUp() {
		cart = new Cart();
	}

	@Test
	public void WhenProductAddedThenItShouldBeRetainedInTheCart() {
		
		Product product = new Product(1L);
		cart.addProduct(product);
		
		assertEquals(cart.getProductList().size(), 1);
	}
	
	@Test
	public void WhenProductIsRemoavedThenItShouldBeDeletedFromTheCart() {
		
		Product productOne = new Product(1L);
		cart.addProduct(productOne);
		
		Product productTwo = new Product(2L);
		cart.addProduct(productTwo);
		
		cart.removeProduct(productOne.getId());
		
		assertEquals(cart.getProductList().size(), 1);
		assertTrue(cart.getProductList().get(0).equals(productTwo));
	}
	
}

