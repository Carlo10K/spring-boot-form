package com.example.springboot.form.app.controllers;

import com.example.springboot.form.app.models.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "formulario usuario");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model /*@RequestParam String username, @RequestParam String password, @RequestParam String email*/){

        /* si la clase tiene los mismos nombres no es necesario inicializarla y se puede
        poblar la clase
         */
        /*Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);*/

        model.addAttribute("titulo", "resultado form");

        model.addAttribute("usuario", usuario);
        return "resultado";
    }



}
