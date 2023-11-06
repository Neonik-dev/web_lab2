package se.ifmo.web.hard_lab2.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.model.UpdateTable;
import se.ifmo.web.hard_lab2.utils.ErrorPrinter;
import se.ifmo.web.hard_lab2.utils.MapperRequestBodyToDirtyPoint;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/server/areaChecker")
public class AreaCheckServlet extends HttpServlet {
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        try {
//            UpdateTable.update(request, getServletContext());
//            getServletContext().getRequestDispatcher("result.jsp").forward(request, response);
//        } catch (Exception e) {
//            Map<String, Object> jsonResponse = new HashMap<>() {{
//                put("error", e.getMessage());
//            }};
//            String jsonText = new Gson().toJson(jsonResponse);
//
//            response.setContentType("application/json");
//            response.getWriter().write(jsonText);
//            response.setStatus(401);
//        }
//    }

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