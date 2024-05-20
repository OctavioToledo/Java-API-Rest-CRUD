package com.apirestSC.APIRESTsc.Controllers;

import com.apirestSC.APIRESTsc.Entities.Producto;
import com.apirestSC.APIRESTsc.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProducts() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto"));
    }

    @PostMapping
    public Producto createProduct(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto detailProduct) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el product"));

        producto.setNombre(detailProduct.getNombre());
        producto.setPrecio(detailProduct.getPrecio());
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public Producto deleteProductById(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encuentra el product"));

      productoRepository.delete(producto);

        return producto;

    }
}