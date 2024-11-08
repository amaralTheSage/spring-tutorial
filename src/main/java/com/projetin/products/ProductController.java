package com.projetin.products;


import com.projetin.products.Product;
import com.projetin.products.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts(){
        return this.service.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable("id") long id){
        return this.service.findProduct(id);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody @Valid Product body){
        return this.service.createProduct(body);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProduct(@PathVariable("id") long id){
        return this.service.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable("id") long id, @RequestParam(required = false) String title,
                           @RequestParam(required =
                                   false) float price){
        return this.service.updateProduct(id, title, price);
    }
}
