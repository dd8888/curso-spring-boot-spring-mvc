package com.openwebinars.spring.controladores;

import com.openwebinars.spring.modelos.Empleado;
import com.openwebinars.spring.servicios.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private EmpleadoServicio servicio;

    @GetMapping({"/", "/empleado/list"})
    public String listado(Model model) {
        model.addAttribute("listaEmpleados", servicio.findAll());
        return "list";
    }

    @GetMapping("/empleado/new")
    public String nuevoEmpleadoForm(Model model) {
        model.addAttribute("empleadoForm", new Empleado());
        return "form";
    }

    @PostMapping("/empleado/new/submit")
    public String nuevoEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado nuevoEmpleado, BindingResult bindingResult,
    @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            if(!file.isEmpty()){
                //TODO almacenamiento del fichero
            }
            servicio.add(nuevoEmpleado);
            return "redirect:/empleado/list";
        }
    }

    @GetMapping("/empleado/edit/{id}")
    public String editarEmpleadoForm(@PathVariable long id, Model model) {
        Empleado empleado = servicio.findById(id);
        if (empleado != null) {
            model.addAttribute("empleadoForm", empleado);
            return "form";
        } else {
            return "redirect:/empleado/new";
        }
    }

    @PostMapping("/empleado/edit/submit")
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado editEmpleado, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            servicio.editEmpleado(editEmpleado);
            return "redirect:/empleado/list";
        }
    }

}
