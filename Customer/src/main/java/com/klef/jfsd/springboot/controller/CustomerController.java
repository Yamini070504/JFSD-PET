package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("customer")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

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

      mv.setViewName("login");
      mv.addObject("message", msg);
    } catch (Exception e) {
      mv.setViewName("displayerror");
      msg = e.getMessage();
      mv.addObject("message", msg);
    }
    return mv;
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
  
  
    @GetMapping("displaycategory")
    public ModelAndView  displaycategorydemo()
    {
         ModelAndView mv=new ModelAndView("displaycategory");
         return mv;
    }
   
  }