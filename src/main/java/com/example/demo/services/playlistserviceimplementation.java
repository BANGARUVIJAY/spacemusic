package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.playlist;
import com.example.demo.repository.playlistrepository;

@Service
public class playlistserviceimplementation implements playlistservice
{
	@Autowired
   playlistrepository repo;
	@Override
	public void addplaylist(playlist playlist) 
	{
		repo.save(playlist);	
	}
	@Override
	public List<playlist> fetchallplaylists() 
	{
		return repo.findAll();
	}
   
}
