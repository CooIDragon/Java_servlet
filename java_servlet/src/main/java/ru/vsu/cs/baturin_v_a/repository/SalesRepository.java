package ru.vsu.cs.baturin_v_a.repository;

import java.util.List;

public interface SalesRepository<T> {
    List<String> printSales();
    void add(T sale);
}
