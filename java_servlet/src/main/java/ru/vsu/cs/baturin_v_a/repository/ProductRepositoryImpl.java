package ru.vsu.cs.baturin_v_a.repository;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository<Product, UUID> {
    private DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();

    public void add(Product product) {
        dbManager.executeUpdate("INSERT INTO products (article, product_name, page_count, price, quantity) "
                + "VALUES ('"
                + product.getArticle() + "', '"
                + product.getName() + "', '"
                + product.getPageCount() + "', '"
                + product.getPrice() + "', '"
                + product.getQuantity() + "');");
    }

    public void update(Product product) {
        dbManager.executeUpdate("UPDATE products SET "
                + "product_name = '" + product.getName() + "', "
                + "page_count = '" + product.getPageCount() + "', "
                + "price = '" + product.getPrice() + "', "
                + "quantity = '" + product.getQuantity() + "' "
                + "WHERE article = " + product.getArticle() + ";");
    }

    public Product get(UUID id) {
        Product product = null;
        try (ResultSet rs = dbManager.executeQuery("SELECT * FROM products WHERE id = " + id + ";")) {
            rs.next();
            product = new Product(UUID.fromString(rs.getString("id")),
                    rs.getInt("article"),
                    rs.getString("product_name"),
                    rs.getInt("page_count"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getByArticle(int article) {
        Product product = null;
        try (ResultSet rs = dbManager.executeQuery("SELECT * FROM products WHERE article = " + article + ";")) {
            rs.next();
            product = new Product(UUID.fromString(rs.getString("id")),
                    rs.getInt("article"),
                    rs.getString("product_name"),
                    rs.getInt("page_count"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<String> printProducts() {
        List<String> productsInfo = new ArrayList<>();

        try (ResultSet rs = dbManager.executeQuery("SELECT * FROM products;")) {
            while (rs.next()) {
                String productInfo = "article: " + rs.getInt("article")
                        + " name: " + rs.getString("product_name")
                        + " page count: " + rs.getInt("page_count")
                        + " price: " + rs.getDouble("price")
                        + " quantity: " + rs.getInt("quantity");
                productsInfo.add(productInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productsInfo;
    }


}
