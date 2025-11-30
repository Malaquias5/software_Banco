package com.villanueva.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaBancariaRepository extends JpaRepository<com.villanueva.banco.entity.CuentaBancaria, Integer> {
}