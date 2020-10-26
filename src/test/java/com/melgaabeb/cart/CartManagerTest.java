package com.melgaabeb.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;

import com.melgaabeb.cart.bean.Product;
import com.melgaabeb.cart.manager.CartManager;
import com.melgaabeb.cart.manager.CartManagerImpl;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class CartManagerTest {
	
	private CartManager cartManager;
	
	@BeforeEach
	public void setUp() {
		cartManager = new CartManagerImpl();
	}

	@Test
	public void WhenProductAddedThenItShouldBeRetainedInTheCart() {
		
		Product product = new Product(1L, 1.2);
		cartManager.addProduct(product);
		
		List<Product> producstList = cartManager.getCart().getProducts().get(1L);
		
		assertEquals(cartManager.getCart().getProducts().keySet().size(), 1);
		assertEquals(producstList.size(), 1);
	}
	
	@Test
	public void WhenProductIsRemoavedThenItShouldBeDeletedFromTheCart() {
		
		Product productOne = new Product(1L, 1.2);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L, 2.1);
		cartManager.addProduct(productTwo);
		
		cartManager.removeOneItemOfProduct(productOne.getId());
		
		assertEquals(cartManager.getProductsCount(1L) , 0);
		assertEquals(cartManager.getProductsCount(2L) , 1);
	}
	
	@Test
	public void WhenGetProductCountIsCalledThenItShouldReturnProductsCountOnTheCart() {
		
		Product productOne = new Product(1L, 1.2);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L, 2.1);
		cartManager.addProduct(productTwo);
		
		assertEquals(cartManager.getProductsCount() , 2);

	}
	
	@Test
	public void WhenGetProductCountIsCalledUsingProductIdThenItShouldReturnProductsCountRelatedToThisIdTheCart() {
		
		Product productOne = new Product(1L, 1.2);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L, 2.1);
		cartManager.addProduct(productTwo);
		
		Product productThree = new Product(2L, 2.1);
		cartManager.addProduct(productThree);
		
		assertEquals(cartManager.getProductsCount(1L) , 1);
		assertEquals(cartManager.getProductsCount(2L) , 2);

	}
	
	@Test
	public void WhenGetTotalPriceIsCalledThenItShouldReturnThePriceofTheCart() {
		
		Product productOne = new Product(1L, 1.2);
		cartManager.addProduct(productOne);
		
		Product productTwo = new Product(2L, 2.1);
		cartManager.addProduct(productTwo);
		
		Product productThree = new Product(2L, 2.1);
		cartManager.addProduct(productThree);
		
		assertEquals(cartManager.getTotalPrice() , 5.4);

	}
	
}

