package com.example.crud.service;

import com.example.crud.model.ProductModel;
import com.example.crud.repository.ProductRepository;
import com.example.crud.model.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Iterable<ProductModel> getAllProducts() {
        return repository.findAll();
    }

    public Optional<ProductModel> getProductById(String id) {
        return repository.findById(id);
    }

    public void registerProduct(RequestProduct data) {
        ProductModel productModel = new ProductModel(data);
        repository.save(productModel);
    }

    public boolean updateProduct(String id, RequestProduct data) {
        Optional<ProductModel> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()) {
            ProductModel productModel = optionalProduct.get();
            productModel.setName(data.name());
            productModel.setPrice_in_cents(data.price_in_cents());
            repository.save(productModel);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(String id) {
        Optional<ProductModel> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()) {
            repository.delete(optionalProduct.get());
            return true;
        } else {
            return false;
        }
    }
}
