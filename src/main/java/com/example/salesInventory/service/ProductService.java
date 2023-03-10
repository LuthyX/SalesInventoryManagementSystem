package com.example.salesInventory.service;

import com.example.salesInventory.exception.ProductDoesNotExistException;
import com.example.salesInventory.model.Product;
import com.example.salesInventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(Long id) throws ProductDoesNotExistException {
        Optional<Product> oproduct = productRepository.findById(id);
        if(!oproduct.isPresent()){
        throw new ProductDoesNotExistException();
        }
        Product product = oproduct.get();
        return product;
    }

}
