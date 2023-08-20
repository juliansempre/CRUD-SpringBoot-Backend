package com.example.crud.model;

import org.springframework.data.jpa.repository.JpaRepository;
//Aponte para Manipular a entidade ProductModel
public interface ProductRepository extends JpaRepository<ProductModel, String> {
}
