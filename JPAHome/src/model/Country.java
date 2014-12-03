package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the COUNTRY database table.
 * 
 */
@Entity
@Table(name="APP.COUNTRY")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private List<Employee> employees;

	public Country() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(unique=true, nullable=false, length=3)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Column(nullable=false, length=25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="countryBean")
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setCountryBean(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setCountryBean(null);

		return employee;
	}


	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", employees="
				+ employees + "]";
	}

}