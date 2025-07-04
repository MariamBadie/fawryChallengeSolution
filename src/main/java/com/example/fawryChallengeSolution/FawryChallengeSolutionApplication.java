package com.example.fawryChallengeSolution;

import com.example.fawryChallengeSolution.models.*;
import com.example.fawryChallengeSolution.services.ShippingService;
import java.time.LocalDate;
import java.util.List;

public class FawryChallengeSolutionApplication {

	public static void main(String[] args) {
		try {
				Cheese cheese = new Cheese("Cheddar Cheese", 5.0, 10, LocalDate.now().plusDays(5), 1.0);
				TV tv = new TV("Samsung TV", 300.0, 5, 10.0);
				Mobile mobile = new Mobile("iPhone Scratch Card", 50.0, 20);
				Biscuit biscuit = new Biscuit("Chocolate Biscuit", 2.0, 15, LocalDate.now().minusDays(1), 0.5);


				Customer customer = new Customer("Alice", 500.0);


				customer.getCart().addProduct(cheese, 2);
				customer.getCart().addProduct(tv, 1);
				customer.getCart().addProduct(mobile, 1);

				// This one is to test expired item error
				//customer.getCart().addProduct(biscuit, 1);

				Cart cart = customer.getCart();

				if (cart.isEmpty()) {
					throw new Exception("Cart is empty!");
				}

				for (CartItem item : cart.getItems()) {
					if (item.getProduct().isExpired()) {
						throw new Exception("Product " + item.getProduct().getName() + " is expired.");
					}
					if (item.getQuantity() > item.getProduct().getQuantity()) {
						throw new Exception("Not enough stock for product " + item.getProduct().getName());
					}
				}

				double subtotal = cart.getSubtotal();
				List<Shippable> shippables = cart.getShippableItems();
				double shipping = ShippingService.calculateShipping(shippables);
				double total = subtotal + shipping;

				if (customer.getBalance() < total) {
					throw new Exception("Insufficient balance");
				}

				for (CartItem item : cart.getItems()) {
					item.getProduct().decreaseQuantity(item.getQuantity());
				}

				customer.deductBalance(total);

				if (!shippables.isEmpty()) {
					ShippingService.printShipmentNotice(cart.getItems());
				}

				System.out.println("\n** Checkout receipt **");
				for (CartItem item : cart.getItems()) {
					double linePrice = item.getQuantity() * item.getProduct().getPrice();
					System.out.printf("%dx %s %.0f%n", item.getQuantity(), item.getProduct().getName(), linePrice);
				}
				System.out.println("-----------------");

				System.out.println("Subtotal: $" + subtotal);
				System.out.println("Shipping: $" + shipping);
				System.out.println("Total Paid: $" + total);
				System.out.println("-----------------");

				System.out.println("Customer" + customer.getName() +"Balance After Payment: $" + customer.getBalance());


			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
		}
	}
}

