package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.users;

public interface usersrepository extends JpaRepository<users,Integer>
{
   public users findByEmail(String email);
}
