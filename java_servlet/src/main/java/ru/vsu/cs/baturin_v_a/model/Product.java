package ru.vsu.cs.baturin_v_a.model;

import java.util.UUID;

public class Product implements Identifiable<UUID> {
    private UUID id;
    private int article;
    private String name;
    private double price;
    private int quantity;
    private int pageCount;

    public Product (UUID id, int article, String name, int pageCount, double price, int quantity) {
        this.id = id;
        this.article = article;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pageCount = pageCount;
    }

    public Product (int article, String name, int pageCount, double price, int quantity) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.pageCount = pageCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    // Метод для вывода информации о газете
    public void print() {
        System.out.println("Article: " + article + ", Name: " + name + ", Page Count: " + pageCount + ", Price: " + price + ", Quantity: " + quantity);
    }
}
