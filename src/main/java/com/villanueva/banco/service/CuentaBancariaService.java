package com.villanueva.banco.service;

import com.villanueva.banco.entity.Cliente;
import com.villanueva.banco.entity.CuentaBancaria;
import com.villanueva.banco.repository.ClienteRepository;
import com.villanueva.banco.repository.CuentaBancariaRepository;
import org.springframework.stereotype.Service;

@Service
public class CuentaBancariaService {
    private final CuentaBancariaRepository cuentaRepo;
    private final ClienteRepository clienteRepo;

    public CuentaBancariaService(CuentaBancariaRepository cuentaRepo, ClienteRepository clienteRepo) {
        this.cuentaRepo = cuentaRepo;
        this.clienteRepo = clienteRepo;
    }

    // Abrir nueva cuenta bancaria para un cliente
    public CuentaBancaria abrirCuenta(Integer idCliente, CuentaBancaria cuenta) {
        Cliente cliente = clienteRepo.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cuenta.setCliente(cliente); // Asignar el cliente a la cuenta
        return cuentaRepo.save(cuenta); // Guardar en BD
    }

    // Consultar cuenta por ID
    public CuentaBancaria consultarCuenta(Integer idCuenta) {
        return cuentaRepo.findById(idCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }
}
