package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.model.Post;
import com.example.blog.model.User;
import com.example.blog.service.BlogService;
import com.example.blog.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller                  // klasa mapująca żądania protokołu http
public class BlogController {
    private BlogServiceImpl blogService;    // obiekt klasy BlogServiceImpl jest wstrzykiwany do BlogController
    @Autowired
    public BlogController(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }
    @GetMapping("/")        // na adresie URL localhost:8080/
    public String home(Model model){   // wywoływana jest metoda zwracająca String
        // Model - klasa do przekazywania parametrów pomiędzy warstwą Front i Back -end
        // model.addAttribute("nazwa obiektu w front-end", obiekt przekazywany z back_end);
        List<Post> posts = blogService.getAllPosts();   // pobranie postów z DB
        model.addAttribute("header_title", "BLOG IT");
        model.addAttribute("header_author", "Michal Kruczkowski");
        model.addAttribute("posts", posts); // przekazanie listy postów do front-end
        return "blog";      // wartością zwracaną jest nazwa szablony Thymeleaf
                            // -> domyślna lokalizacja to resources/templates
                            // -> nie dopisujemy rozszerzenia .html
    }
    @GetMapping("/posts&{postId}")
    public String getPost(@PathVariable("postId") Long postId, Model model){
        Optional<Post> postOpt = blogService.getPostById(postId);
        if(postOpt.isPresent()){
            model.addAttribute("post", postOpt.get());
            return "post";
        }
        model.addAttribute("post", null);
        return "post";
    }
}
