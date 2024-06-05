package ru.vsu.cs.baturin_v_a.servlets;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-product")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();

        int article = Integer.parseInt(req.getParameter("article"));
        String name = req.getParameter("name");
        int pageCount = Integer.parseInt(req.getParameter("pageCount"));
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        ProductServiceImpl productService = ProductServiceImpl.getInstance();

        Product product = new Product(article, name, pageCount, price, quantity);
        productService.addProduct(product);

        resp.sendRedirect("/app");
        dbManager.closeConnection();
    }
}
