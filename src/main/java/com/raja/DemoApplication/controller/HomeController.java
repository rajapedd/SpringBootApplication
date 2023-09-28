package com.raja.DemoApplication.controller;

import com.raja.DemoApplication.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @RequestMapping("/")
    public String home(){
        return "Hello Raja.............!";
    }
   // @RequestMapping(value = "/user" , method = RequestMethod.GET)
    @GetMapping("/user")
    public User setUsers() {
        User u=new User();
        u.setId("1");
        u.setName("Raja");
        u.setEmali("raja@gmail.com");
        return u;
    }
}
