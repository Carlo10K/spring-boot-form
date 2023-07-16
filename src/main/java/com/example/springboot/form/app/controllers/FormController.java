package com.example.springboot.form.app.controllers;

import com.example.springboot.form.app.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "formulario usuario");
        return "form";
    }

    @PostMapping("/form")  /*@Valid para usar la libreria de validacion jakarta, El objeto binding result de spring obtiene el resultado
                            de la validacion y siempre debe ir despues del objeto a validar*/
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model /*@RequestParam String username, @RequestParam String password, @RequestParam String email*/){

        /* si la clase tiene los mismos nombres no es necesario inicializarla y se puede
        poblar la clase
         */
        /*Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);*/

        model.addAttribute("titulo", "resultado form");

        /* manejo de errores automaticos */
        if (result.hasErrors()){
            /* si el result retorna error aqui se maneja */
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), "El campo ".concat(error.getField()).concat(" ").concat(Objects.requireNonNull(error.getDefaultMessage())));
            });
            model.addAttribute("error", errors);
            return "form";
        }

        model.addAttribute("usuario", usuario);
        return "resultado";
    }



}
