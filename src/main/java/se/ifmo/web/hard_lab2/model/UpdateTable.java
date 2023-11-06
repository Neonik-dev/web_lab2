package se.ifmo.web.hard_lab2.model;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import se.ifmo.web.hard_lab2.dto.AllPoints;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;
import se.ifmo.web.hard_lab2.dto.Point;
import se.ifmo.web.hard_lab2.exceptions.InvalidDataExceptions;

import java.io.IOException;

import static se.ifmo.web.hard_lab2.filter.ValidatePointFilter.VALID_POINT_FROM_REQUEST;

public class UpdateTable {
    public static final String ALL_POINTS_ATTRIBUTE = "points";

    public static void update(HttpServletRequest request, ServletContext servletContext) {
        Point point = (Point) request.getAttribute(VALID_POINT_FROM_REQUEST);

        AllPoints points = (AllPoints) servletContext.getAttribute(ALL_POINTS_ATTRIBUTE);
        if (points == null) {
            points = new AllPoints();
            servletContext.setAttribute(ALL_POINTS_ATTRIBUTE, points);
        }
        points.addNewPoint(point);
    }
}
