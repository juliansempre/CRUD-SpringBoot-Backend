package com.example.crud.repository;

import com.example.crud.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
//Aponte para Manipular a entidade ProductModel
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
