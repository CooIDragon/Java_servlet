package ru.vsu.cs.baturin_v_a.repository;

import ru.vsu.cs.baturin_v_a.model.Identifiable;

import java.util.List;
import java.util.UUID;

public interface ProductRepository <T extends Identifiable<Id>, Id>{
    List<String> printProducts();
    T get(UUID x);
    T getByArticle(int x);
    void add(T product);
    void update(T product);
}
