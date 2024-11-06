package com.example.crud.Controllers;

import com.example.crud.Entities.Producto;
import com.example.crud.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController{

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id){
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);

    }

    @PutMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id, @RequestBody Producto detalleProducto) {
        Producto producto = productoRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No se encontro el producto con el ID: " + id));

        producto.setNombre(detalleProducto.getNombre());
        producto.setPrecio(detalleProducto.getPrecio());

        return productoRepository.save(producto);

    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productoRepository.delete(producto);
        return "El producto con el id:" + id + " fue eliminado";

    }


}