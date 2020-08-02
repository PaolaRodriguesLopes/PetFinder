package com.example.pet_finder.repository;

import com.example.pet_finder.entity.Pet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository <Pet,Integer> {
    
}