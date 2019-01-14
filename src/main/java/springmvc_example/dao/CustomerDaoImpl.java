package springmvc_example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc_example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Customer> listAllCustomers() {
		Criteria criteria = getSession().createCriteria(Customer.class);
		return criteria.list();
	}

	public void saveOrUpdate(Customer customer) {
		getSession().saveOrUpdate(customer);
	}

	public Customer findCustomerById(int id) {
		Customer customer = getSession().get(Customer.class, id);
		return customer;
	}

	public void deleteCustomer(int id) {
		Customer customer = getSession().get(Customer.class, id);
		getSession().delete(customer);
	}

}
