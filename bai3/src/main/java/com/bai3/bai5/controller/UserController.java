package com.bai3.bai5.controller;

import com.bai3.bai5.entity.User;
import com.bai3.bai5.service.UserService;
import com.bai3.bai5.service.PHONGBANService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("")
@Controller
public class UserController {
    @Autowired
    private UserService UserService;
    @Autowired
    private PHONGBANService categoryService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Đăng nhập");
        return "User/login";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("title","Đăng ký");
        model.addAttribute("user",new User());

        return "User/register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid User User, BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
            User.setPassword(new BCryptPasswordEncoder().encode(User.getPassword()));
            UserService.save(User);
            return "redirect:/login";
        }
        model.addAttribute("title","Đăng ký");
        return "User/register";
    }

}
