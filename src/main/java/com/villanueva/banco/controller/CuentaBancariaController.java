package com.villanueva.banco.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaBancariaController {

    @PostMapping
    public String crearCuenta() {
        return "Cuenta creada";
    }

    @GetMapping
    public String listarCuentas() {
        return "Listado de cuentas";
    }

    @GetMapping("/{id}")
    public String buscarCuenta(@PathVariable Long id) {
        return "Cuenta encontrada con ID: " + id;
    }
}
