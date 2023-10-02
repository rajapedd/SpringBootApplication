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

    @GetMapping("/{id}/{id2}")
    public String getPathVariable(@PathVariable String id, @PathVariable("id2") String name){
        return "The Path Variable is "+id+ " : "+name;
    }

    @GetMapping("/userName")
    public String requestParam(@RequestParam String userName,
                               @RequestParam(name ="email", required = false, defaultValue = "") String emailID ){
        return "My name is Raja "+userName +" And Email Id is :"+emailID;
    }
}
