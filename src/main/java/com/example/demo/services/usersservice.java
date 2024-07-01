package com.example.demo.services;

import com.example.demo.entity.users;

public interface usersservice {
	
	public String adduser(users user);
	public boolean emailexists(String email);
	public boolean validateuser(String email,String password);
	public String getroll(String email);
	
	public users getuser(String email);
	public void updateuser(users user);
	

}
