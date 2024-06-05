package ru.vsu.cs.baturin_v_a.servlets;

import ru.vsu.cs.baturin_v_a.model.Product;
import ru.vsu.cs.baturin_v_a.model.Sales;
import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;
import ru.vsu.cs.baturin_v_a.service.SalesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sell-product")
public class SellServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();

        int saleArticle = Integer.parseInt(req.getParameter("saleArticle"));
        int saleQuantity = Integer.parseInt(req.getParameter("saleQuantity"));

        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        Product saleProduct = productService.getProductByArticle(saleArticle);
        SalesServiceImpl salesService = SalesServiceImpl.getInstance();
        Sales sale = null;
        if (saleProduct != null && saleProduct.getQuantity() >= saleQuantity) {
            sale = new Sales(saleProduct, saleQuantity);
            salesService.addSale(sale);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Sale completed successfully.");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("Product not found or not enough in stock.");
        }

        dbManager.closeConnection();

        resp.sendRedirect("/app");
    }
}
