package com.villanueva.banco.entity;

import jakarta.persistence.*; // Anotaciones JPA
import lombok.*; // Para generar getters/setters automáticamente
import java.io.Serializable;

@Entity // Indica que esta clase es una tabla en la BD
@Table(name = "Cliente") // Nombre de la tabla en la BD
@Data // Genera automáticamente getters, setters, toString, hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los atributos
public class Cliente implements Serializable {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Integer id;

    @Column(name = "nombres_completos", nullable = false, length = 150) // No puede ser nulo
    private String nombresCompletos;

    @Column(nullable = false, unique = true, length = 120) // Email único y obligatorio
    private String email;

    @Column(nullable = false, length = 1) // Estado activo/inactivo
    private String estado = "1"; // Por default activo
}
