package com.clase1910.proyecto1.prueba01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class PersonalController {

    @GetMapping("/info_persona")
    public String info(Model model){
        model.addAttribute("nombre", "Juan");
        return "info_persona";
    }
   
    
}

