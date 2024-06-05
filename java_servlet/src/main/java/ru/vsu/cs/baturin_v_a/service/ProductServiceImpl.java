package ru.vsu.cs.baturin_v_a.service;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.repository.ProductRepositoryImpl;

import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements ProductService<Product, UUID> {
    private static ProductServiceImpl instance;
    private ProductRepositoryImpl productRepository;

    private ProductServiceImpl() {
        productRepository = new ProductRepositoryImpl();
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public Product getProduct(UUID id) {
        return productRepository.get(id);
    }

    public Product getProductByArticle(int article) {
        return productRepository.getByArticle(article);
    }

    public List<String> printAllProducts() {
        return productRepository.printProducts();
    }

}
