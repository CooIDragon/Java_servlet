package ru.vsu.cs.baturin_v_a.servlets;

import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;
import ru.vsu.cs.baturin_v_a.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/print-inv")
public class PrintInvServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();

        ProductServiceImpl productService = ProductServiceImpl.getInstance();

        List<String> inv = productService.printAllProducts();
        for(int i = 0; i < inv.size(); i++){
            resp.getWriter().write(inv.get(i));
            resp.getWriter().write("\n");
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Inventory printed successfully");
        dbManager.closeConnection();
    }

}
