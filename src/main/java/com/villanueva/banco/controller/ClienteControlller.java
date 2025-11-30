package com.villanueva.banco.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @PostMapping
    public String registrarCliente() {
        return "Cliente registrado correctamente";
    }

    @GetMapping
    public String listarClientes() {
        return "Listado de clientes";
    }

    @GetMapping("/{id}")

    public String obtenerCliente(@PathVariable Long id) {
        return "Cliente encontrado con ID: " + id;
    }
}
