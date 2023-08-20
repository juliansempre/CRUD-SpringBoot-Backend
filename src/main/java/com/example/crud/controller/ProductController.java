package com.example.crud.controller;

import com.example.crud.model.ProductModel;
import com.example.crud.model.ProductRepository;
import com.example.crud.model.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.Optional;

//RequestMapping indica qual endpoint esse controler é responsagel
//ResponseEntity gerar respostas
//Migrations executa e é um registro historico do banco de dados
/*
Para criar uma migration basta criar um arquivo SQL dentro de:
projeto/main/resources/db/migration
O nome do arquivo deve respeitar a seguinte sintaxe:
VX__metodo-nome-tabela
V1__create-table-product.sql
`V3__update-table-foods`
`V9__create-table-user`
`V11__drop-table-user`

flyway_schema_history impede a redundancia na criação de comandos já executados
//O preço é em centavos para o front formatar para float.
@Autowired é injeção de dependencia Classe objeto = new Classe();
return ResponseEntity.ok().build(); para responseEntity vazio
POST
{
    "name": "Camiseta",
    "price_in_cents": 2000
}
Se por string assim: return ResponseEntity.ok("Deu ok, funcionando! "+allProduct);
o json não aparece, gera um toString padrão por causa da concatenação string.

PathVariable receber id na URL
    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data){
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    //Instanciar
    @Autowired
    private ProductRepository repository;
    //Listar
    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProduct = repository.findAll();
        return ResponseEntity.ok(allProduct);
    }
    //Inserir
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestProduct data){
        ProductModel productModel = new ProductModel(data);
        repository.save(productModel);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
        Optional<ProductModel> productModel = Optional.of(repository.getReferenceById(data.id()));
        return ResponseEntity.ok(productModel);
    }
}
