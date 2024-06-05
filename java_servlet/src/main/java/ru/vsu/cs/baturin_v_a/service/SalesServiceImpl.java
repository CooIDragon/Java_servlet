package ru.vsu.cs.baturin_v_a.service;

import ru.vsu.cs.baturin_v_a.model.Sales;
import ru.vsu.cs.baturin_v_a.repository.SalesRepositoryImpl;

import java.util.List;

public class SalesServiceImpl implements SalesService<Sales> {
    private static SalesServiceImpl instance;
    private SalesRepositoryImpl salesRepository;

    private SalesServiceImpl() {
        salesRepository = new SalesRepositoryImpl();
    }

    public static SalesServiceImpl getInstance() {
        if (instance == null) {
            instance = new SalesServiceImpl();
        }
        return instance;
    }

    @Override
    public void addSale(Sales sale) {
        salesRepository.add(sale);
    }

    @Override
    public List<String> printSales() {
        return salesRepository.printSales();
    }
}
