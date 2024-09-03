package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;
import com.klef.jfsd.springboot.repository.ProductRepository;

@Service
public class AdminServiceImpl implements AdminService
{
  @Autowired
  private AdminRepository adminRepository;
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private ProductRepository productRepository;
  

  @Override
  public Admin checkadminlogin(String uname, String pwd) 
  {
    return adminRepository.checkadminlogin(uname, pwd);
  }

  @Override
  public String addcustomer(Customer c) 
  {
    customerRepository.save(c);
    return "Customer Added Successfully";
  }

  

  @Override
  public long customercount() 
  {
    return customerRepository.count();
  }


  @Override
  public List<Customer> viewallcustomer() {
    return customerRepository.findAll();
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
  public String deletecustomer(int cid) 
  {
    Optional<Customer> obj =  customerRepository.findById(cid);
         
         String msg = null;
         
         if(obj.isPresent())
         {
           Customer customer = obj.get();
           
           customerRepository.delete(customer);
           
           msg = "Customer Deleted Successfully";
         }
         else
         {
           msg = "Customer Not Found";
         }
         
         return msg;
  }

  @Override
  public List<Product> viewallproducts() {
      return (List<Product>) productRepository.findAll();
  }

  @Override
  public String deleteproduct(int eid) 
  {
    Optional<Product> obj =  productRepository.findById(eid);
         
         String msg = null;
         
         if(obj.isPresent())
         {
           Product product = obj.get();
           
           productRepository.delete(product);
           
           msg = "Pet Deleted Successfully";
         }
         else
         {
           msg = "Pet Not Found";
         }
         
         return msg;
  }

  @Override
  public Product viewproductbyid(int id) {
    Optional<Product> obj = productRepository.findById(id);

    if (obj.isPresent()) {
      Product p = obj.get();

      return p;
    } else {
      return null;
    }
  }

  @Override
  public String displaycategory(int pid) {
      Optional<Product> obj = productRepository.findById(pid);

      if (obj.isPresent()) {
          Product product = obj.get();
          String category = product.getCategory(); 
          if (category != null) {
              return category;
          } else {
              return "Category Not Found";
          }
      } else {
          return "Product Not Found";
      }
  }



  
}