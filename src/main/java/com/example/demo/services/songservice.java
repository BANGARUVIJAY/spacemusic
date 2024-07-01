package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.song;

public interface songservice {

	public void addsong(song song);

	public List<song> fetchallsongs();
	
	public boolean songexists(String name);
	
	public void updatesong(song song);
}
