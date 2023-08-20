package com.example.crud.model;

import jakarta.persistence.*;
import lombok.*;

//@EqualsAndHashCode(of = "id") idica o tipo da primary key
//Contrutor e getters e setters
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = "id")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer price_in_cents;

    //construtor
    public ProductModel(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price_in_cents = requestProduct.price_in_cents();
    }
    //Pode ter mais de um construtor
    public ProductModel(String name, Integer price){

    }
}
