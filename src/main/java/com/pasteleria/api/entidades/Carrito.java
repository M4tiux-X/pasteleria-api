package com.pasteleria.api.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito;
    private int id_usuario;
    private LocalDate fec_creacion;
    private int total;
    private String estado;
    
    public Long getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(Long id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_Usuario() {
        return id_usuario;
    }

    public void setId_Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public LocalDate getFec_creacion() {
        return fec_creacion;
    }

    public void setFec_creacion(LocalDate fec_creacion) {
        this.fec_creacion = fec_creacion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Carrito() {
    }
}
