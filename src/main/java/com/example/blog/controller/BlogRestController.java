package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController   // kontroler generujący wyniki w postaci REST API
//@Controller     // kontrolek komunikujący się z warstwą front-end
public class BlogRestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/{name}")        // {var} - zmienna osadzona w ścieżce
    public String helloMe(@PathVariable("name") String name){
        return "hello " + name.toUpperCase();
    }

}
