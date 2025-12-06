package com.pasteleria.api.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "descuentos")
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_descuento;
    private String codigo;
    private String descripcion;
    private String tipo;
    private int valor;
    private LocalDate fec_inicion;
    private LocalDate fec_fin;
    private Boolean estado;

    public Long getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(Long id_descuento) {
        this.id_descuento = id_descuento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDate getFec_inicion() {
        return fec_inicion;
    }

    public void setFec_inicion(LocalDate fec_inicion) {
        this.fec_inicion = fec_inicion;
    }

    public LocalDate getFec_fin() {
        return fec_fin;
    }

    public void setFec_fin(LocalDate fec_fin) {
        this.fec_fin = fec_fin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Descuento(){
    }
}
