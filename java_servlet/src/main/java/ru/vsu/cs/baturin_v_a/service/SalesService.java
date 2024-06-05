package ru.vsu.cs.baturin_v_a.service;

import java.util.List;

public interface SalesService <T>{
    void addSale(T sale);
    List<String> printSales();
}