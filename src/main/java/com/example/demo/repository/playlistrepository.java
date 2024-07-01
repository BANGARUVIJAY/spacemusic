package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.playlist;

public interface playlistrepository extends JpaRepository<playlist,Integer>
{
  
}
