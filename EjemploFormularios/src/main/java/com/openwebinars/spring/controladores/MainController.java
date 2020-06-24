package com.openwebinars.spring.controladores;

import com.openwebinars.spring.modelos.Empleado;
import com.openwebinars.spring.servicios.EmpleadoServicio;
import com.openwebinars.spring.upload.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private EmpleadoServicio servicio;

    @Autowired
    private StorageService storageService;

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
            if (!file.isEmpty()) {
                String avatar = storageService.store(file, nuevoEmpleado.getId());
                nuevoEmpleado.setImagen(MvcUriComponentsBuilder.fromMethodName(MainController.class, "serveFile"
                        , avatar).build().toUriString());
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
    public String editarEmpleadoSubmit(@Valid @ModelAttribute("empleadoForm") Empleado editEmpleado, BindingResult bindingResult,
                                       @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            if (!file.isEmpty()) {
                String avatar = storageService.store(file, editEmpleado.getId());
                editEmpleado.setImagen(MvcUriComponentsBuilder.fromMethodName(MainController.class, "serveFile"
                        , avatar).build().toUriString());
            }
            servicio.editEmpleado(editEmpleado);
            return "redirect:/empleado/list";
        }
    }

    @GetMapping("/files/filename:.+")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().body(file);
    }


}
