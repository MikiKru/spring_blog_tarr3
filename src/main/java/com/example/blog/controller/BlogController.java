package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                  // klasa mapująca żądania protokołu http
public class BlogController {
    @GetMapping("/")        // na adresie URL localhost:8080/
    public String home(Model model){   // wywoływana jest metoda zwracająca String
        // Model - klasa do przekazywania parametrów pomiędzy warstwą Front i Back -end
        // model.addAttribute("nazwa obiektu w front-end", obiekt przekazywany z back_end);
        model.addAttribute("header_title", "BLOG IT");
        model.addAttribute("header_author", "Michal Kruczkowski");
        return "blog";      // wartością zwracaną jest nazwa szablony Thhymeleaf
                            // -> domyślna lokalizacja to resources/templates
                            // -> nie dopisujemy rozszerzenia .html
    }
}
