package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.*;

public interface AdminService 
{
  public Admin checkadminlogin(String uname, String pwd);
  public List<Customer> viewallcustomer();
  public List<Product> viewallproducts();
  public Product viewproductbyid(int id);
  public String addcustomer(Customer c);
  public long customercount();  
  public Customer viewcustomerbyid(int cid);
  public String deletecustomer(int cid); 
  public String deleteproduct(int eid);
  public String addproduct(Product product);
  public String displaycategory(int eid);
}