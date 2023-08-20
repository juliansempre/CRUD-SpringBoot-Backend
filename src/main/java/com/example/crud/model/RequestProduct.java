package com.example.crud.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Classe para validação, ah tem que vir um name e um integer
public record RequestProduct(String id, @NotBlank  String name, @NotNull Integer price_in_cents) {
}
