package ru.vsu.cs.baturin_v_a.servlets;

import ru.vsu.cs.baturin_v_a.repository.database.DatabaseManagerImpl;
import ru.vsu.cs.baturin_v_a.service.SalesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/print-sales")
public class PrintSalesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DatabaseManagerImpl dbManager = DatabaseManagerImpl.getInstance();
        dbManager.connect();

        SalesServiceImpl salesService = SalesServiceImpl.getInstance();

        List<String> inv = salesService.printSales();
        for(int i = 0; i < inv.size(); i++){
            resp.getWriter().write(inv.get(i));
            resp.getWriter().write("\n");
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("Sales printed successfully");
        dbManager.closeConnection();
    }

}