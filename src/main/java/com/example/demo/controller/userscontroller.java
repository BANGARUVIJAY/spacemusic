package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.users;
import com.example.demo.services.usersservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class userscontroller {
	@Autowired
	usersservice service;
	
 @PostMapping("/register")
 public String addusers(@ModelAttribute users user)
  {
	 boolean userstatus=service.emailexists(user.getEmail());
	 if(userstatus==false)
	 {
	service.adduser(user);
	System.out.println("user added");
	 }
	 else 
	 {
		 System.out.println("user already exists");
	 }
	return "home";
  }
 
 @PostMapping("/validate")
 public String validate(@RequestParam("email")String email,
		 @RequestParam("password")String password,HttpSession session)
  {
	 if(service.validateuser(email,password)==true)
	 {
		 String role=service.getroll(email);
		 session.setAttribute("email", email);
		 if(role.equals("admin"))
		 {
			 return "adminhome";
		 }
		 else
		 {
			 return "customerhome";
		 }		 
	 }
	 else
	 {
		 return "login";
	 }
  }
 

 @GetMapping("/logout")
 public String logout(HttpSession session)
 {
	 session.invalidate();
	 return "login";
 }
 
}