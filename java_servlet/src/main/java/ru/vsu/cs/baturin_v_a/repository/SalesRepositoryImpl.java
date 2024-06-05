package ru.vsu.cs.baturin_v_a.repository;

import ru.vsu.cs.baturin_v_a.model.Sales;
import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesRepositoryImpl implements SalesRepository<Sales> {
    private DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();

    public void add(Sales sales) {
        dbManager.executeUpdate("INSERT INTO sales (product_id, quantity, total_price) "
                + "VALUES ('"
                + sales.getProduct().getId() + "', '"
                + sales.getQuantity() + "', '"
                + sales.getTotalPrice() + "');");

        int dx = sales.getProduct().getQuantity() - sales.getQuantity();

        // Use PreparedStatement for the update query
        String updateQuery = "UPDATE products SET quantity = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = dbManager.getConnection().prepareStatement(updateQuery);
            preparedStatement.setInt(1, dx); // Set the first parameter to dx
            preparedStatement.setObject(2, sales.getProduct().getId()); // Set the second parameter to product ID
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<String> printSales() {
        List<String> salesDetails = new ArrayList<>();
        int article = 0;
        String name = null;
        ResultSet rs1 = dbManager.executeQuery("SELECT *\n" +
                "FROM products\n" +
                "JOIN sales ON products.id = sales.product_id;");
        try {
            while (rs1.next()) {
                article = rs1.getInt("article");
                name = rs1.getString("product_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (ResultSet rs = dbManager.executeQuery("SELECT * FROM sales;")) {
            while (rs.next()) {
                String salesInfo = "article: " + article
                        + " name: " + name
                        + " quantity: " + rs.getInt("quantity")
                        + " total_price: " + rs.getDouble("total_price");
                salesDetails.add(salesInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesDetails;
    }

}

