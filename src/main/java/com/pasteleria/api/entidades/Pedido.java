package com.pasteleria.api.entidades;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;
    private Long id__carrito;
    private LocalDate fec_pedido;
    private int total;
    private String estado_pedido;
    private String direccion_entrga;
    private String medio_pago;
    private LocalDate fec_entrega;

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Long getId__carrito() {
        return id__carrito;
    }

    public void setId__carrito(Long id__carrito) {
        this.id__carrito = id__carrito;
    }

    public LocalDate getFec_pedido() {
        return fec_pedido;
    }

    public void setFec_pedido(LocalDate fec_pedido) {
        this.fec_pedido = fec_pedido;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(String estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    public String getDireccion_entrga() {
        return direccion_entrga;
    }

    public void setDireccion_entrga(String direccion_entrga) {
        this.direccion_entrga = direccion_entrga;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public LocalDate getFec_entrega() {
        return fec_entrega;
    }

    public void setFec_entrega(LocalDate fec_entrega) {
        this.fec_entrega = fec_entrega;
    }

    public Pedido() {
    }
}
