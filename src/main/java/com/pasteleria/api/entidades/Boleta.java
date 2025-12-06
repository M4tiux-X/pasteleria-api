package com.pasteleria.api.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_boleta;
    private Long id_pedido;
    private LocalDate fec_emision;
    private int total;
    private int impuestos;
    private String medio_pago;

    public Long getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(Long id_boleta) {
        this.id_boleta = id_boleta;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getFec_emision() {
        return fec_emision;
    }

    public void setFec_emision(LocalDate fec_emision) {
        this.fec_emision = fec_emision;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(int impuestos) {
        this.impuestos = impuestos;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public Boleta() {
    }
}
