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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.model.Product;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class AdminController {
  @Autowired
  private AdminService adminService;
  
  

  @GetMapping("/")
  public String main() {
    return "adminlogin";
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

  


  @GetMapping("adminhome")
  public ModelAndView adminhome() {

    long customercount = adminService.customercount();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminhome");
    mv.addObject("ccount", customercount);
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

    @Autowired
	private ProductService productService;
	
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
	   String productlink = request.getParameter("productlink");
	   
		  byte[] bytes = file.getBytes();
		  Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		  
		  Product p = new Product();
		  p.setCategory(category);
		  p.setName(name);
		  p.setDescription(description);
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
   
   @PostMapping("payment")
   public ModelAndView payment() {
     ModelAndView mv = new ModelAndView();
     mv.setViewName("payment");
     return mv;
   }
    
    
  }