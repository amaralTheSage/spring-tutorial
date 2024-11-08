package com.projetin.products;

import com.projetin.products.Product;
import com.projetin.products.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts(){
        return this.repository.findAll();
    }

    public Product findProduct(long id){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("Product not found");
        }

        return this.repository.findById(id).get();
    }

    public Product createProduct(Product body){
        return this.repository.save(body);
    }

    public Product deleteProduct(long id){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("Product not found");
        }

        Product product = this.repository.findById(id).get();
        this.repository.deleteById(id);

        return product;
    }

    public Product updateProduct(long id, String title, Float price){
        if(this.repository.findById(id).isEmpty()){
            throw new IllegalStateException("Product not found");
        }

        Product product = this.repository.findById(id).get();

        if(title !=null && !title.isEmpty()){
            product.setTitle(title);
        }

        if(price !=null){
            product.setPrice(price);
        }

        return product;
    }
}
