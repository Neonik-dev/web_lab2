package se.ifmo.web.hard_lab2.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;
import se.ifmo.web.hard_lab2.model.Validator;
import se.ifmo.web.hard_lab2.utils.ErrorPrinter;
import se.ifmo.web.hard_lab2.utils.MapperRequestBodyToDirtyPoint;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/server/*")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/server/areaChecker").forward(request, response);
        } catch (Exception e) {
            ErrorPrinter.print(response, e.getMessage());
        }
    }
}
