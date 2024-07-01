package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.playlist;

public interface playlistservice {

	public void addplaylist(playlist playlist);

	public List<playlist> fetchallplaylists();
}
