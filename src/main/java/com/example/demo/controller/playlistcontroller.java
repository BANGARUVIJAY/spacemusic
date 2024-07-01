package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.playlist;
import com.example.demo.entity.song;
import com.example.demo.services.songservice;
import com.example.demo.services.playlistservice;

@Controller
public class playlistcontroller {
@Autowired
songservice songservice;

@Autowired
playlistservice playlistservice;

@GetMapping("/createplaylist")
public String createplaylist(Model model)
{
	List<song> songlist=songservice.fetchallsongs();
	model.addAttribute("songs",songlist);	
	return "createplaylist";
}

@PostMapping("/addplaylist")
public String addplaylist(@ModelAttribute playlist playlist)
 {
	//updating playList table
     playlistservice.addplaylist(playlist);
     //updating song table
     List<song> songlist=playlist.getSong();
     for(song s:songlist)
     {
    	s.getPlaylist().add(playlist); 
    	songservice.updatesong(s);
     }
     return "adminhome";
 }

@GetMapping("/viewplaylists")
public String viewplaylists(Model model)
{
	List<playlist> allplaylists=playlistservice.fetchallplaylists();
	model.addAttribute("allplaylists",allplaylists);
	return "displaylists";
}

}
