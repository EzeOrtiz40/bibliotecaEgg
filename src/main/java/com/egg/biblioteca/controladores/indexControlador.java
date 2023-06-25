package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexControlador {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}

