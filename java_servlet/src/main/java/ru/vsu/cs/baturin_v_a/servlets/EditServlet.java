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

@WebServlet("/edit-product")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();

        int editArticle = Integer.parseInt(req.getParameter("editArticle"));
        ProductServiceImpl productService = ProductServiceImpl.getInstance();
        Product editProduct = productService.getProductByArticle(editArticle);
        if (editProduct != null) {
            String newName = req.getParameter("enewName");
            int pageCount = Integer.parseInt(req.getParameter("epageCount"));
            double newPrice = Double.parseDouble(req.getParameter("enewPrice"));
            int newQuantity = Integer.parseInt(req.getParameter("enewQuantity"));

            editProduct.setName(newName);
            editProduct.setPageCount(pageCount);
            editProduct.setPrice(newPrice);
            editProduct.setQuantity(newQuantity);
            productService.updateProduct(editProduct);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Product successfully edited.");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().println("Product not found.");
        }

        dbManager.closeConnection();

        resp.sendRedirect("/app");
    }
}
