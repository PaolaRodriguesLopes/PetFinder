package com.example.pet_finder.service;

import java.util.List;

import com.example.pet_finder.entity.Pet;
import com.example.pet_finder.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepo;

    public void deletePet (Pet pet)
    {
        petRepo.delete(pet);
    }

    public void insert (Pet pet)
    {
        petRepo.save(pet);
    }

    public List<Pet> getPets()
    {
        return petRepo.findAll();
    }

   
    public Pet getPetById(int id)
    {
        return petRepo.findById(id).get();
    }

    
}