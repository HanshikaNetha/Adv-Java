package com.example.SpringMvcProductApp.Controller;

import com.example.SpringMvcProductApp.Model.Product;
import com.example.SpringMvcProductApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private final ProductService service;

    public ProductRestController(ProductService service){
        this.service=service;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return service.getProductById(id).orElseThrow(()->new RuntimeException("product not found"));
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        service.saveProduct(product);
        return "Product added successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return "Product Deleted";
    }
}
