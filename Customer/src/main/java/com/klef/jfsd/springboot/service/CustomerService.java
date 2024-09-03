package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.Customer;

public interface CustomerService 
{
    public String addcustomer(Customer customer);
    public String updatecustomer(Customer customer);
    public Customer viewcustomerbyid(int cid);
    public Customer checkcustomerlogin(String email,String pwd);
}