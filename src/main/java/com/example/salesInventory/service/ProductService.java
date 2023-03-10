package com.example.salesInventory.service;

import com.example.salesInventory.exception.ProductDoesNotExistException;
import com.example.salesInventory.model.Product;
import com.example.salesInventory.repository.ProductRepository;
import com.example.salesInventory.request.ChangeProductPriceRequest;
import com.example.salesInventory.request.CreateProductRequest;
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

    public void addProduct(CreateProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        productRepository.save(product);
    }
    public Product changeProductPrice(ChangeProductPriceRequest request) throws ProductDoesNotExistException {
        Optional<Product> oproduct = productRepository.findById(request.getId());
        if (!oproduct.isPresent()) {
            throw new ProductDoesNotExistException();
        }
        Product product = oproduct.get();
        product.setPrice(request.getPrice());
        productRepository.save(product);
        return product;
    }
}
