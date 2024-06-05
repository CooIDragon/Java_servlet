package ru.vsu.cs.baturin_v_a.service;

import ru.vsu.cs.baturin_v_a.model.Identifiable;

import java.util.List;

public interface ProductService<T extends Identifiable<Id>, Id> {
    void addProduct(T product);


    void updateProduct(T product);

    T getProduct(Id id);

    T getProductByArticle(int article);

    List<String> printAllProducts();
}
