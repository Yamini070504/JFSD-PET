package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int id;
	@Column(name="customer_name",nullable=false,length = 50)
	private String name;
	@Column(name="customer_gender",length = 10)
	private String gender;
	@Column(name="customer_dob",length = 20)
	private String dateofbirth;
	@Column(name="customer_salary")
	private double salary;
	@Column(name="customer_email",nullable=false,unique = true,length = 30)
	private String email;
	@Column(name="customer_password",nullable=false,length = 30)
	private String password;
	@Column(name="customer_location")
	private String location;
	@Column(name="customer_contact",nullable=false,unique = true)
	private String contact;
	@Column(name="customer_active",nullable=false)
	private boolean active; 
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public String getDateofbirth() 
	{
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) 
	{
		this.dateofbirth = dateofbirth;
	}
	public double getSalary() 
	{
		return salary;
	}
	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
	}
	public String getContact() 
	{
		return contact;
	}
	public void setContact(String contact) 
	{
		this.contact = contact;
	}
	public boolean isActive() 
	{
		return active;
	}
	public void setActive(boolean active) 
	{
		this.active = active;
	}
	@Override
	public String toString() 
	{
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth
				+ ", salary=" + salary + ", email=" + email + ", password=" + password
				+ ", location=" + location + ", contact=" + contact + ", active=" + active + "]";
	}
}
