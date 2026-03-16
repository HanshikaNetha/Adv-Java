package org.example.ManyToOne;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="department_seq", sequenceName="department_sequence", initialValue=101, allocationSize=1)
	private int id;
	private String deptNAme;
	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL)
	private List<Employee> employees;
	public Department() {
		
	}
	public Department(String deptNAme) {
		this.deptNAme=deptNAme;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeptNAme() {
		return deptNAme;
	}
	public void setDeptNAme(String deptNAme) {
		this.deptNAme = deptNAme;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
