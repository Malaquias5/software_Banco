package com.villanueva.banco.service;

import com.villanueva.banco.entity.Cliente;
import com.villanueva.banco.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    // Método para registrar un cliente
    public Cliente registrarCliente(Cliente cliente) {
        return clienteRepo.save(cliente); // Guarda en BD y devuelve el objeto con ID
    }

}
