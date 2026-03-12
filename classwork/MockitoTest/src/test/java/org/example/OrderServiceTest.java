package org.example;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.anyDouble;

public class OrderServiceTest {
	@Mock
	PaymentService paymentServiceMock;
	@InjectMocks
	OrderService orderService;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		System.out.println("\n Setting up the fresh mocks for next test.");
	}
	
	@Test
	@DisplayName("Test successful order placement")
	public void testPlaceOrder_Success() {
		when(paymentServiceMock.processPayment(500.0)).thenReturn(true);
	}
	@Test
	@DisplayName("Test filed order placemnt")
	public void testPlaceOrder_failure() {
		when(paymentServiceMock.processPayment(300.0)).thenReturn(false);
		String result=orderService.placeOrder(300.0);
		Assertions.assertEquals("Payment Failed", result);
		verify(paymentServiceMock).processPayment(300.0);
	}
	
	@Test
	@DisplayName("Test with any amount-mock returns true for any amount")
	public void testPlaceOrder_anyAmount() {
		when(paymentServiceMock.processPayment(anyDouble())).thenReturn(true);
		String result=orderService.placeOrder(999.99);
		Assertions.assertEquals("Order Placed", result);
		verify(paymentServiceMock).processPayment(anyDouble());
	}
	//testing exceptions
	@Test
	@DisplayName("Test when payment service throws exception")
	public void testPlaceOrder_Exception() {
		when(paymentServiceMock.processPayment(anyDouble())).thenThrow(new RuntimeException("Bank API down"));
		RuntimeException exception=Assertions.assertThrows(RuntimeException.class, ()->orderService.placeOrder(100.0));
		Assertions.assertEquals("Bank API down", exception.getMessage());
		verify(paymentServiceMock).processPayment(anyDouble());
	}
}
