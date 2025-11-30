package com.villanueva.banco.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "operacion")
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public Operacion() {
    }

    public Operacion(Integer id, Cliente cliente, CuentaBancaria cuentaBancaria, String tipoOperacion, BigDecimal monto, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.cuentaBancaria = cuentaBancaria;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}