package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.song;
import com.example.demo.repository.songrepository;

@Service
public class songserviceimplementation implements songservice{

	@Autowired
	songrepository repo;
	@Override
	public void addsong(song song) {
		
		repo.save(song);
	}
	@Override
	public List<song> fetchallsongs() {
		
		return repo.findAll();
	}
	@Override
	public boolean songexists(String name) {
		song song=repo.findByName(name);
		if(song==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	@Override
	public void updatesong(song song) {
		repo.save(song);
		
	}

}
