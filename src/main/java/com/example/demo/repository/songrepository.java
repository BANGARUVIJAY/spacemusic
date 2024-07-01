package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.song;

public interface songrepository 
                   extends JpaRepository<song,Integer> {
	public song findByName(String name);
	

}
