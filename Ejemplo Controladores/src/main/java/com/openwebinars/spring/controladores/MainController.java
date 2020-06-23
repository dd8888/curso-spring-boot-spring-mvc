package com.openwebinars.spring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class MainController {


    //Esto puede dar error si no se envía ningún parámetro.
    /*@GetMapping("/")
    public String welcome(@RequestParam("name") String name, Model model){
        //model.addAttribute("mensaje", "mi pana miguel");
        model.addAttribute("nombre", name);
        return "index";
    }*/

    //Esto no da error si no se le envía el parámetro, sino que muestra el valor por defecto.
    @GetMapping("/")
    public String welcome(@RequestParam("name") Optional<String> name, Model model){
        //model.addAttribute("mensaje", "mi pana miguel");
        model.addAttribute("nombre", name.orElse("Mundo"));
        return "index";
    }

    //@PathVariable recoge una parte de la URL
    @GetMapping("/saludo/{name}")
    public String saludo(@PathVariable String name, Model model){
        model.addAttribute("saludo", "Hola " + name);
        //model.addAttribute("saludo", "jaja si no");
        return "saludo";
    }



}
