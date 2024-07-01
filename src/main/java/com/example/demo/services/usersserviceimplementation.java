package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.users;
import com.example.demo.repository.usersrepository;
@Service
public class usersserviceimplementation implements usersservice{
@Autowired
	usersrepository repo;
	@Override
	public String adduser(users user) 
	{
		repo.save(user);
		return "user added successfully";
	}
	
	@Override
	public boolean emailexists(String email)
	{
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	public boolean validateuser(String email, String password) 
	{
	   users user=repo.findByEmail(email);
	   String dbpassword=user.getPassword();
	   if(password.equals(dbpassword))
	   {
		   return true;
	   }
	   else 
	   {
		  return false;
	   }
	}

	@Override
	public String getroll(String email) 
	{
		users user=repo.findByEmail(email);
		return user.getRole();
	}

	@Override
	public users getuser(String email)
	{
		return repo.findByEmail(email);
	}

	@Override
	public void updateuser(users user) 
	{
		repo.save(user);
		
	}
}
