package se.ifmo.web.hard_lab2.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.model.UpdateTable;
import se.ifmo.web.hard_lab2.utils.ErrorPrinter;

@WebServlet(value = "/server/areaChecker")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            UpdateTable.update(request, getServletContext());

            response.setCharacterEncoding("UTF-8");
            getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
        } catch (Exception e) {
            ErrorPrinter.print(response, e.getMessage());
        }
    }
}