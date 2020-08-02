package com.example.pet_finder.service;

import java.util.List;

import com.example.pet_finder.entity.LoginUsers;
import com.example.pet_finder.exception.CriptoExistException;
import com.example.pet_finder.exception.ServiceExc;
import com.example.pet_finder.repository.LoginUsersRepository;
import com.example.pet_finder.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUsersService {
    @Autowired
    private LoginUsersRepository userRepo;
    
    public void insert (LoginUsers loginUser) throws Exception{
        try {
            
            loginUser.setLoginPassword(Util.md5(loginUser.getLoginPassword()));
            
       
        } catch (Exception e) {
            throw new CriptoExistException("Erro na criptografia da senha");
        }
        userRepo.save(loginUser);
    }

    public List<LoginUsers> getUsers()
    {
        return userRepo.findAll();
    }
   
    public LoginUsers loginUser (String user, String pass) throws ServiceExc 
    {
        List<LoginUsers> users = userRepo.findAll();
        LoginUsers userFound = new LoginUsers();

       
        for(LoginUsers u: users){
            
            if(u.getEmail().equals(user) && u.getLoginPassword().equals(pass)){
                userFound = u;

            }
        }
        return userFound;
    }

    public LoginUsers getUserById(int id)
    {
        return userRepo.findById(id).get();
    }
}