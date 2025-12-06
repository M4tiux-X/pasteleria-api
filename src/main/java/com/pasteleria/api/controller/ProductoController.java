package com.pasteleria.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.pasteleria.api.entidades.Producto;
import com.pasteleria.api.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo){
        this.repo=repo;
    }

    @GetMapping
    public List<Producto> getProductos(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Producto getById(@PathVariable Long id){
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Producto agreProducto(@RequestBody Producto producto){
        return repo.save(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto){
        Optional<Producto> data = repo.findById(id);

        if(data.isPresent()){
            Producto p = data.get();
            p.setCategoria(producto.getCategoria());
            p.setNombre_prod(producto.getNombre_prod());
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
            p.setImagen(producto.getImagen());
            return repo.save(p);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Eliminado correctamente";
        }
        return "No existe registro";
    }
}
