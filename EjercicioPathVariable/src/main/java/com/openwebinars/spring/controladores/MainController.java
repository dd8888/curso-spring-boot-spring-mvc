package com.openwebinars.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @GetMapping("/saludo/{nombre}/{apellido}")
    public String name(@PathVariable String nombre, @PathVariable String apellido, Model model){
        model.addAttribute("nombre", "Hola " + nombre + " " + apellido);
        return "saludo";

    }

}
