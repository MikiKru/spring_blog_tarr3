package com.example.blog.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorPageController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "redirect:/myErrorPage";
    }
    @GetMapping("/myErrorPage")
    public String getErrorPage(){
        return "errorPage";
    }
}
