package org.example.entity;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="cutomer_seq", sequenceName="customer_sequence", initialValue=1, allocationSize=1)
	private int id;
	private String name;
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
	private List<Order> orders;
	public Customer() {
		
	}
	public Customer( String name, List<Order> orders) {
		this.name=name;
		this.orders=orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
