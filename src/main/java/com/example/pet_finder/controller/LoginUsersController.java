package com.example.pet_finder.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.example.pet_finder.entity.LoginUsers;
import com.example.pet_finder.exception.ServiceExc;
import com.example.pet_finder.service.LoginUsersService;
import com.example.pet_finder.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginUsersController {
    @Autowired
    private LoginUsersService userService;
    
    @GetMapping("/registerUser")
    public ModelAndView setRegister()
    {
        ModelAndView mv = new ModelAndView("RegisterUser");
        return mv;
    }

    @GetMapping("/loginPage")
    public ModelAndView getLogin()
    {
        ModelAndView mv = new ModelAndView("LoginUser");
        return mv;
    }

    @GetMapping("/index")
    public ModelAndView getIndex()
    {
        ModelAndView mv = new ModelAndView("pq");
        return mv;
    }
    
    @PostMapping("/insertUser")
    public String insert (@ModelAttribute LoginUsers loginUser) throws Exception
    {
        userService.insert(loginUser);

        return "redirect:/loginPage";
    }  

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginUsers users, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc
    {
        ModelAndView mv = new ModelAndView("LoginUser");
        mv.addObject("loginUser", new LoginUsers());
        if(br.hasErrors()){
            mv.setViewName("/loginPage");
        }
        LoginUsers user = userService.loginUser(users.getEmail(), Util.md5(users.getLoginPassword()));
        
        if(user.getEmail() == null){
            mv.addObject("msg", "E-mail/senha incorreto. Tente novamente");
        }else{
            session.setAttribute("userSession", user);
            return getIndex();
        }
        return mv;
    }

    
}