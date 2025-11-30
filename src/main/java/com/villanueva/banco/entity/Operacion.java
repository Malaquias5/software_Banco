package com.villanueva.banco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "operacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // ID de la operación

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;  // FK a Cliente

    @ManyToOne
    @JoinColumn(name = "id_cuenta_bancaria", nullable = false)
    private CuentaBancaria cuentaBancaria; // FK a Cuenta

    @Column(name = "tipo_operacion", nullable = false, length = 2)
    private String tipoOperacion;  // '01' Depósito, '02' Retiro

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal monto; // Monto de operación

    @Column(nullable = false, length = 1)
    private String estado = "1"; // '1' Activo, '0' Cancelado
}
