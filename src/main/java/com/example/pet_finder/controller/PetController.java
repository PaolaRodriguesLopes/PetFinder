package com.example.pet_finder.controller;

import com.example.pet_finder.entity.LoginUsers;
import com.example.pet_finder.entity.Pet;
import com.example.pet_finder.service.LoginUsersService;
import com.example.pet_finder.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
    
    @Autowired
    private PetService petService;

    @Autowired 
    private LoginUsersService userService;

   

    @GetMapping("/petPage/{id}")
    public ModelAndView getPetPage(@PathVariable(name="id") Integer id)
    {
        LoginUsers loginUser = userService.getUserById(id);

        ModelAndView mv = new ModelAndView("RegisterPet");

        mv.addObject("insert", "insert");
        mv.addObject("idUser", loginUser.getIdLoginUser());
        mv.addObject("cityUser", loginUser.getCity());

        return mv;
    

    }
   

    @PostMapping("/insertPet")
    public String insert (@ModelAttribute Pet pet) 
    {
        petService.insert(pet);

        return "redirect:/allPetsByUser/" + pet.getIdUser().getIdLoginUser();
    }  
    

    @GetMapping("/allPets")
    public ModelAndView getPets(Pet pets)
    {
        ModelAndView mv = new ModelAndView("AllPets");

        mv.addObject("pets", petService.getPets());

        return mv;
    }

    @GetMapping("/allPetsByUser/{id}")
    public ModelAndView getPetsByUser(@PathVariable(name="id") Integer id)
    {
        LoginUsers login = userService.getUserById(id);
        ModelAndView mv = new ModelAndView("AllPetsByUser");


        mv.addObject("pets", login.getPets());

        return mv;
    }

    @GetMapping("/deletePet")
    public String delete (@RequestParam Integer id)
    {
        Pet pet = petService.getPetById(id);

        petService.deletePet(pet);
                     
        return "redirect:/allPetsByUser/" + pet.getIdUser().getIdLoginUser();
    }

    @GetMapping("/updatePet")
    public ModelAndView updateAuthors (@RequestParam Integer id)
    {
        ModelAndView mv = new ModelAndView("RegisterPet");

        Pet pet = petService.getPetById(id);

        mv.addObject("pet", pet);
        mv.addObject("update", "update");


        return mv;
    }
   
}