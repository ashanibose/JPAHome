package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPT database table.
 * 
 */
@Entity
@Table(name="APP.DEPT")
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<Employee> employees;

	public Dept() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=10)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Column(length=20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="dept")
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDept(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDept(null);

		return employee;
	}


	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", employees=" + employees
				+ "]";
	}
	
	

}