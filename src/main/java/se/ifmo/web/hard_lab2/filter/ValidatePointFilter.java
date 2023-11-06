package se.ifmo.web.hard_lab2.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;
import se.ifmo.web.hard_lab2.dto.Point;
import se.ifmo.web.hard_lab2.exceptions.InvalidDataExceptions;
import se.ifmo.web.hard_lab2.model.Validator;
import se.ifmo.web.hard_lab2.utils.ErrorPrinter;
import se.ifmo.web.hard_lab2.utils.MapperRequestBodyToDirtyPoint;

import java.io.IOException;

@WebFilter("/server/*")
public class ValidatePointFilter implements Filter {
    public static final String VALID_POINT_FROM_REQUEST = "point";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            DirtyPoint dirtyPoint = MapperRequestBodyToDirtyPoint.mapper(servletRequest);
            Point point = new Validator(dirtyPoint).validate();
            servletRequest.setAttribute(VALID_POINT_FROM_REQUEST, point);

            filterChain.doFilter(servletRequest, servletResponse);
        } catch (InvalidDataExceptions | IOException e) {
            ErrorPrinter.print((HttpServletResponse) servletResponse, e.getMessage());
        }


//        String x = request.getParameter("param_x");
//        String y = request.getParameter("param_y");
//        String r = request.getParameter("param_r");
//
//        if (Validator.validate(x, y, r)) {
//            Attempt attempt = new Attempt(x, y, r);
//
//            HttpSession session = ((HttpServletRequest) request).getSession();
//
//            CollectionAttempts attempts = (CollectionAttempts) session.getAttribute("collectionAttempts");
//            if (attempts == null) {
//                attempts = new CollectionAttempts();
//                session.setAttribute("collectionAttempts", attempts);
//            }
//
//            attempts.add(attempt);
//
//            filterChain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse) response).sendRedirect("/lab2/filter.jsp");
//        }
    }
}
