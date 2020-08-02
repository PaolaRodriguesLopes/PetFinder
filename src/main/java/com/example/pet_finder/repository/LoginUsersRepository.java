package com.example.pet_finder.repository;



import com.example.pet_finder.entity.LoginUsers;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginUsersRepository extends JpaRepository<LoginUsers,Integer> {
     
}