package se.ifmo.web.hard_lab2.dto;

import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class AllPoints implements Serializable {
    private final Map<Double, List<Point>> points = new HashMap<>();

    public void addNewPoint(Point point) {
        points.putIfAbsent(point.r(), new ArrayList<>());
        points.get(point.r()).add(point);
    }
}
