package com.pasteleria.api.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito_detalle")
public class CarritoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrito_detalle;
    private Long id__carrito;
    private int cantidad;
    private int subtotal;
    private String id_producto;
    
    public Long getId_carrito_detalle() {
        return id_carrito_detalle;
    }

    public void setId_carrito_detalle(Long id_carrito_detalle) {
        this.id_carrito_detalle = id_carrito_detalle;
    }

    public Long getId__carrito() {
        return id__carrito;
    }

    public void setId__carrito(Long id__carrito) {
        this.id__carrito = id__carrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public CarritoDetalle() {
    }
}
