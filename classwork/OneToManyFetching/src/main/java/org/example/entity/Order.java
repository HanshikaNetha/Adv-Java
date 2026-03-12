package org.example.entity;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="order_seq", sequenceName="order_sequence", initialValue=101, allocationSize=1)
	private int id;
	private LocalDate orderdate;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order() {
		
	}
	public Order(LocalDate orderDate) {
		this.orderdate=orderDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}
	
}
