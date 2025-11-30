package com.villanueva.banco.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/operaciones")
public class OperacionController {

    @PostMapping("/depositar")

    public String depositar() {
        return "Depósito realizado";
    }
    @PostMapping("/retirar")
    public String retirar() {
        return "Retiro realizado";
    }
    @PostMapping("/transferir")
    public String transferir() {
        return "Transferencia realizada";
    }
}
