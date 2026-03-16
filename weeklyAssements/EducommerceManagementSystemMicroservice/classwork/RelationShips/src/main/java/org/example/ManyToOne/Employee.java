package org.example.ManyToOne;
import javax.persistence.*;
@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name="employee_seq", sequenceName="employee_sequence", initialValue=1, allocationSize=1)
	private int id;
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id")
	private Department dept;
	public Employee() {
		
	}
	public Employee(String name, Department dept) {
		this.name=name;
		this.dept=dept;
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
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
