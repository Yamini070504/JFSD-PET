package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.CustomerService;
import com.klef.jfsd.springboot.service.EmailService;
import com.klef.jfsd.springboot.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController {
  @Autowired
  private AdminService adminService;
  @Autowired
  private CustomerService customerService;
  @Autowired
  private ProductService productService;
  @Autowired
  private EmailService emailService;

  @GetMapping("/")
  public String main() {
    return "login";
  }

  @GetMapping("about")
  public ModelAndView aboutus() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("about");
    return mv;
  }

  @GetMapping("booking")
  public ModelAndView booknow() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("booking");
    return mv;
  }

  @GetMapping("contact")
  public ModelAndView contactus() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("contact");
    return mv;
  }

  @GetMapping("login")
  public ModelAndView loggedin() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

  @GetMapping("pet")
  public ModelAndView petsavailable() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("pet");
    return mv;
  }

  @GetMapping("price")
  public ModelAndView pricing() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("price");
    return mv;
  }

  @GetMapping("service")
  public ModelAndView servicing() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("service");
    return mv;
  }

  @GetMapping("index")
  public ModelAndView indexing() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("index");
    return mv;
  }

  @GetMapping("customerreg")
  public ModelAndView customerregistration() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("customerreg");
    return mv;
  }

  @GetMapping("customerlogin")
  public ModelAndView customerlogin() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("customerlogin");
    return mv;
  }

  @PostMapping("checkcustomerlogin")
  public ModelAndView checkcustomerlogin(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();

    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");

    Customer customer = customerService.checkcustomerlogin(email, pwd);

    if (customer != null) {

      HttpSession session = request.getSession();

      session.setAttribute("cid", customer.getId());
      session.setAttribute("cname", customer.getName());

      mv.setViewName("index");
    } else {
      mv.setViewName("login");
      mv.addObject("message", "Login Failed");
    }
    return mv;
  }

  @GetMapping("adminhome")
  public ModelAndView adminhome() {

    long customercount = adminService.customercount();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminhome");
    mv.addObject("ccount", customercount);
    return mv;
  }

  @GetMapping("customerhome")
  public ModelAndView customerhome(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("customerhome");

    HttpSession session = request.getSession();
    int cid = (int) session.getAttribute("cid");
    String cname = (String) session.getAttribute("cname");

    mv.addObject("cid", cid);
    mv.addObject("cname", cname);
    return mv;
  }

  @GetMapping("adminlogin")
  public ModelAndView adminlogin() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminlogin");
    return mv;
  }

  @PostMapping("checkadminlogin")
  public ModelAndView checkadminlogin(HttpServletRequest request) {
    String uname = request.getParameter("uname");
    String pwd = request.getParameter("pwd");

    Admin a = adminService.checkadminlogin(uname, pwd);

    ModelAndView mv = new ModelAndView();
    if (a != null) {

      long customercount = adminService.customercount();
      mv.setViewName("adminhome");
      mv.addObject("ccount", customercount);
    } else {
      mv.setViewName("adminlogin");
      mv.addObject("message", "Login Failed");
    }
    return mv;
  }

  @GetMapping("viewallcustomers")
  public ModelAndView viewallcustomers() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewallcustomers");

    List<Customer> customerlist = adminService.viewallcustomer();
    mv.addObject("customerdata", customerlist);
    return mv;
  }

  @PostMapping("insertcustomer")
  public ModelAndView insertaction(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();

    String msg = null;

    try {
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String pwd = request.getParameter("pwd");
      String loc = request.getParameter("location");
      String contact = request.getParameter("contact");

      Customer customer = new Customer();
      customer.setName(name);
      customer.setEmail(email);
      customer.setLocation(loc);
      customer.setPassword(pwd);
      customer.setContact(contact);
      customer.setActive(true);

      msg = customerService.addcustomer(customer);
      //emailService.sendEmail(customer.getEmail(),"Successfully registered","Hi, You have successfully registered into the pet adoption portal...Hope you get the services for your pets and also discover through new pets..!!!");

      mv.setViewName("login");
      mv.addObject("message", msg);
    } catch (Exception e) {
      mv.setViewName("displayerror");
      msg = e.getMessage();
      mv.addObject("message", msg);
    }
    return mv;
  }

  @GetMapping("view")
  public ModelAndView viewcustomerdemo(@RequestParam("id") int eid) {
    Customer customer = adminService.viewcustomerbyid(eid);
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewcustomerbyid");
    mv.addObject("customer", customer);
    return mv;
  }

  @GetMapping("deletecustomer")
  public ModelAndView deletecustomer() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("deletecustomer");

    List<Customer> customerlist = adminService.viewallcustomer();

    mv.addObject("customerdata", customerlist);

    return mv;
  }

  @GetMapping("delete/{id}")
  public String deleteaction(@PathVariable("id") int cid) {
    adminService.deletecustomer(cid);
    return "redirect:/deletecustomer";
  }

  @GetMapping("updateprofile")
  public ModelAndView updatecustomer(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView();

    HttpSession session = request.getSession();

    mv.setViewName("updateprofile");

    mv.addObject("cid", session.getAttribute("cid"));
    mv.addObject("cname", session.getAttribute("cname"));

    int id = (int) session.getAttribute("cid");

    Customer customer = customerService.viewcustomerbyid(id);

    mv.addObject("customer", customer);

    return mv;
  }

  @PostMapping("update")
  public ModelAndView updateaction(HttpServletRequest request) {
    String msg = null;

    ModelAndView mv = new ModelAndView();

    HttpSession session = request.getSession();

    mv.addObject("cid", session.getAttribute("cid"));
    mv.addObject("cname", session.getAttribute("cname"));

    int id = (int) session.getAttribute("cid");
    try {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String sal = request.getParameter("salary");
        double salary = Double.parseDouble(sal);
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String location = request.getParameter("location");
        String contact = request.getParameter("contact");

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setDateofbirth(dob);
        customer.setSalary(salary);
        customer.setEmail(email);
        customer.setPassword(pwd);
        customer.setLocation(location);
        customer.setContact(contact);

        msg = customerService.updatecustomer(customer);

        mv.setViewName("customerlogin");
        mv.addObject("message", msg);

      } catch (Exception c) {
        msg = c.getMessage();

        mv.setViewName("updateerror");
        mv.addObject("message", msg);
      }

      return mv;

    }

    @GetMapping("updatestatus")
    public ModelAndView updatestatus() {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("updatestatus");

      List<Customer> customerlist = adminService.viewallcustomer();
      mv.addObject("customerdata", customerlist);

      return mv;
    }

    @GetMapping("customerlogout")
    public ModelAndView customerlogout() {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("customerlogin");
      mv.addObject("message", "Logout Successfully");
      return mv;
    }

    @GetMapping("addproduct")
    public ModelAndView addproductdemo()
    {
 	   ModelAndView mv = new ModelAndView("addproduct");
 	   return mv;
    }
    @PostMapping("insertproduct")
    public ModelAndView insertproductdemo(HttpServletRequest request,@RequestParam("productimage") MultipartFile file) throws IOException, SerialException, SQLException
    {
 	   String msg = null;
 	   
 	   ModelAndView mv = new ModelAndView();
 	   
 	   try
 	   {
 	   String category = request.getParameter("category");
 	   String name = request.getParameter("name");
 	   String description = request.getParameter("description");
 	   Double cost = Double.valueOf(request.getParameter("cost"));
 	   String productlink = request.getParameter("productlink");
 	   
 		  byte[] bytes = file.getBytes();
 		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
 		  
 		  Product p = new Product();
 		  p.setCategory(category);
 		  p.setName(name);
 		  p.setDescription(description);
// 		  p.setCost(cost);
 		  p.setProductlink(productlink);
 		  p.setProductimage(blob);
 		  
 		  msg=productService.AddProduct(p);
 		  System.out.println(msg);
 		  mv.setViewName("productmsg");
 		  mv.addObject("message",msg);
 	   }	  
 	   catch(Exception e)
 	   {
 		   msg = e.getMessage();
 		   System.out.println(msg.toString());
 		   mv.setViewName("producterror");
 		   mv.addObject("message",msg);
 	   }
 	   return mv;
    }
    @GetMapping("viewallprods")
    public ModelAndView viewallprodsdemo()
    {
 	   List<Product> productlist = productService.ViewAllProducts();
 	   
 	   ModelAndView mv = new ModelAndView("viewallproducts");
 	   
 	   mv.addObject("productlist", productlist);
 	   
 	   return mv;
    }
    
 @GetMapping("displayprodimage")
 public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException
 {
   Product product =  productService.ViewProductByID(id);
   byte [] imageBytes = null;
   imageBytes = product.getProductimage().getBytes(1,(int) product.getProductimage().length());

   return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
 }

    @GetMapping("viewproductbyid")
 public ModelAndView  viewproductbyiddemo()
 {
 	   List<Product> productlist=productService.ViewAllProducts();
 	   ModelAndView mv=new ModelAndView("viewproductbyid");
 	   mv.addObject("productlist",productlist);
 	   return mv;
 }
    
    @PostMapping("displayproduct")
    public ModelAndView displayproductdemo(HttpServletRequest request)
    {
 	   int pid=Integer.parseInt(request.getParameter("pid"));
 	   Product product=productService.ViewProductByID(pid);
 	   ModelAndView mv=new ModelAndView("displayproduct");
 	   mv.addObject("product",product);
 	   return mv;
    }
    
    @GetMapping("displaycategory")
    public ModelAndView  displaycategorydemo()
    {
         ModelAndView mv=new ModelAndView("displaycategory");
         return mv;
    }
    
    @PostMapping("viewproductsbycategory")
    public ModelAndView  viewproductsbycategorydemo(HttpServletRequest request)
    {
       String category = request.getParameter("category");
       
         List<Product> productlist=productService.viewproductsbycategory(category);
         ModelAndView mv=new ModelAndView("viewproductsbycategory");
         mv.addObject("productlist",productlist);
         return mv;
    }
  }