package springmvc_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_example.model.Customer;
import springmvc_example.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("customer/list");
		List<Customer> list = customerService.listAllCustomers();
		model.addObject("list", list);
		return model;
	}
	
	@RequestMapping(value = "/update/{id}" , method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("customer/form");
		Customer customer = customerService.findCustomerById(id);
		model.addObject("customerForm",customer);
		return model;
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		customerService.deleteCustomer(id);
		return new ModelAndView("redirect:/customer/list");
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("customer/form");
		Customer customer = new Customer();
		model.addObject("customerForm" , customer);
		return model;
	}
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Customer customer) {
		customerService.saveOrUpdate(customer);
		return new ModelAndView("redirect:/customer/list");
	}

}
