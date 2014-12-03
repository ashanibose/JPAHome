package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeptTest {
	private static EntityManager em = null;

	@BeforeClass
	public static void setUp() throws Exception {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAHome_mydb");
		em = emf.createEntityManager();
	}

	@Test
	public void test_connection() {
		System.out.println("-->" + em.isOpen());
	}

	@Test
	public void test_add_dept() {
		Dept dept = new Dept();
		dept.setName("Finance");
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();

	}

	@Test
	public void test_add_emp() {
		Country countryBean = new Country();
		countryBean.setName("INDIA");
		;
		countryBean.setCode("ind");

		Dept dept = new Dept();
		dept.setName("Finance");

		Employee employee = new Employee();
		employee.setCountryBean(countryBean);
		employee.setDept(dept);
		employee.setName("Ashani Basu");
		employee.setEmail("aB@hotmail.com");

		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();

	}

	@Test
	public void test_employee_lookup() {
		System.out.println(em.find(Employee.class, "251").toString());
	}

	@Test
	public void test_remove() {
		Employee employee = em.find(Employee.class, "251");
		em.getTransaction().begin();
		em.remove(employee);
		em.getTransaction().commit();

		assertFalse(em.contains(employee));
	}	
}
