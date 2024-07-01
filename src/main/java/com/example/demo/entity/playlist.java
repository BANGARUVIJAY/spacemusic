package com.example.demo.entity;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class playlist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	@ManyToMany
	List<song> song;
	
	public playlist() {
		super();	
	}
	
	public playlist(int id, String name, List<com.example.demo.entity.song> song) {
		super();
		this.id = id;
		this.name = name;
		this.song = song;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<song> getSong() {
		return song;
	}

	public void setSong(List<song> song) {
		this.song = song;
	}

	@Override
	public String toString() {
		return "playlist [id=" + id + ", name=" + name + ", song=" + song + "]";
	}
	
	
	
	
}
