package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.song;
import com.example.demo.services.songservice;

@Controller
public class songcontroller {
    @Autowired
	songservice service;
    @PostMapping("/addsong")
    public String addsong(@ModelAttribute song song )
    {
    	boolean songstatus=service.songexists(song.getName());
    	if(songstatus==false)
    	{
    		service.addsong(song);
    		System.out.println("song added successfully");
    	}
    	else
    	{
    		System.out.println("song already exists");
    	}
    	
    	return "adminhome";
    }
    
    @GetMapping("/viewsongs")
    public String viewsongs(Model model)
    {
    	List<song> songlist=service.fetchallsongs();
    	model.addAttribute("songs",songlist);
    	return "displaysongs";
    }
	
    @GetMapping("/playsongs")
    public String playsongs(Model model)
    {
    	boolean premiumuser=false;
    	if(premiumuser==true)
    	{
    		List<song> songlist=service.fetchallsongs();
        	model.addAttribute("songs",songlist);
        	return "displaysongs";
    	}
    	else
    	{
    		return "makepayment";
    	}
    }
	
	
}
