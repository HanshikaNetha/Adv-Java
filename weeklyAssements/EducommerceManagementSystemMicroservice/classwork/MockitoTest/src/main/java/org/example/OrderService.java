package org.example;

public class OrderService {
	private PaymentService paymentService;
	//cConstructor Injection
	public OrderService(PaymentService paymentService) {
		this.paymentService=paymentService;
	}
	//method to test
	public String placeOrder(double amount) {
		System.out.println("[OrderService] Placing order...");
		boolean paymentSucess=paymentService.processPayment(amount);
		if(paymentSucess) {
			return "Order placed";
		}
		return "Payment failed";
	}
	public boolean validateAndPlaceOrder(double amount) {
		if(amount<=0) {
			return false;
		}
		boolean paymentSuccess=paymentService.processPayment(amount);
		return paymentSuccess;
	}
}
