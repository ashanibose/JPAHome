package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name="APP.EMPLOYEE")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String email;
	private String manId;
	private String name;
	private Country countryBean;
	private Dept dept;

	public Employee() {
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
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="MAN_ID", length=10)
	public String getManId() {
		return this.manId;
	}

	public void setManId(String manId) {
		this.manId = manId;
	}


	@Column(nullable=false, length=50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="COUNTRY")
	public Country getCountryBean() {
		return this.countryBean;
	}

	public void setCountryBean(Country countryBean) {
		this.countryBean = countryBean;
	}


	//bi-directional many-to-one association to Dept
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="DEPT_ID")
	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", manId=" + manId
				+ ", name=" + name + ", countryBean=" + countryBean + ", dept="
				+ dept + "]";
	}

	
}