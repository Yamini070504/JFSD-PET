package com.klef.jfsd.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addcustomer(Customer customer) 
	{
		customerRepository.save(customer);
		return "Customer Added Successfully";
	}

	@Override
	public String updatecustomer(Customer customer)
	{
		Customer c = customerRepository.findById(customer.getId()).get();
		
		c.setName(customer.getName());
		c.setDateofbirth(customer.getDateofbirth());
		c.setSalary(customer.getSalary());
		c.setEmail(customer.getEmail());
		c.setPassword(customer.getPassword());
		c.setLocation(customer.getLocation());
		c.setContact(customer.getContact());
		
		customerRepository.save(c);
		
		return "Registration Successfully";
	}

	@Override
	public Customer viewcustomerbyid(int cid)
	{
		Optional<Customer> obj =  customerRepository.findById(cid);
	       
	       if(obj.isPresent())
	       {
	         Customer customer = obj.get();
	         
	         return customer;
	       }
	       else
	       {
	         return null;
	       }
	}

	@Override
	public Customer checkcustomerlogin(String email, String pwd) 
	{
		return customerRepository.checkcustomerlogin(email, pwd);
	}

}
