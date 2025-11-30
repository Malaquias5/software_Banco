package com.villanueva.banco.service;

import com.villanueva.banco.entity.Cliente;
import com.villanueva.banco.entity.CuentaBancaria;
import com.villanueva.banco.entity.Operacion;
import com.villanueva.banco.repository.ClienteRepository;
import com.villanueva.banco.repository.CuentaBancariaRepository;
import com.villanueva.banco.repository.OperacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OperacionService {
    private final OperacionRepository operacionRepo;
    private final CuentaBancariaRepository cuentaRepo;
    private final ClienteRepository clienteRepo;

    public OperacionService(OperacionRepository operacionRepo,
                            CuentaBancariaRepository cuentaRepo,
                            ClienteRepository clienteRepo) {
        this.operacionRepo = operacionRepo;
        this.cuentaRepo = cuentaRepo;
        this.clienteRepo = clienteRepo;
    }

    // Registrar operación de depósito o retiro
    public Operacion registrarOperacion(Integer idCliente, Integer idCuenta, Operacion operacion) {
        Cliente cliente = clienteRepo.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        CuentaBancaria cuenta = cuentaRepo.findById(idCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        operacion.setCliente(cliente); // Asociar cliente
        operacion.setCuentaBancaria(cuenta); // Asociar cuenta

        // Actualizar saldo
        if ("01".equals(operacion.getTipoOperacion())) { // Depósito
            cuenta.setSaldo(cuenta.getSaldo().add(operacion.getMonto()));
        } else if ("02".equals(operacion.getTipoOperacion())) { // Retiro
            if (cuenta.getSaldo().compareTo(operacion.getMonto()) < 0) {
                throw new RuntimeException("Saldo insuficiente");
            }
            cuenta.setSaldo(cuenta.getSaldo().subtract(operacion.getMonto()));
        } else {
            throw new RuntimeException("Tipo de operación inválido");
        }

        cuentaRepo.save(cuenta); // Guardar saldo actualizado
        return operacionRepo.save(operacion); // Guardar operación
    }
}