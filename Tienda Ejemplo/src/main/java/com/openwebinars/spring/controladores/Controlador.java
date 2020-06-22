package com.openwebinars.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("mensaje", "mi pana miguel");
        return "index";
    }

    @GetMapping("/contacto")
    public String who(Model model){
        model.addAttribute("contacto", "hola buenas tardes");
        return "contacto";
    }

    @GetMapping("/que")
    public String what(Model model){
        model.addAttribute("que", "venga ya hombre");
        return "que";
    }

}
