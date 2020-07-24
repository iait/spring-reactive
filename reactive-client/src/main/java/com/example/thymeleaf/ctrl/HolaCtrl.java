package com.example.thymeleaf.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaCtrl {
  
    @RequestMapping("/hola")
    public String hola(Model model) {
        model.addAttribute("mensaje", "Hola desde thymeleaf!");
        return "hola"; // nombre del template html en resources
    }
    
}
