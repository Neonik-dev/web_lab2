package se.ifmo.web.hard_lab2.model;

public class AreaChecker {
    public static boolean isInArea(int x, double y, double r) {
        // Circle in top-left quadrant
        if (x <= 0 && y >= 0) {
            return (x * x + y * y) <= (r * r);
        }
        // Rectangle in top-right quadrant
        if (x >= 0 && y >= 0) {
            return (y <= r) && (x <= r);
        }
        // Triangle in bottom-left quadrant
        if (x <= 0 && y <= 0) {
            return (-x <= r / 2) && (-x - r / 2 <= y);
        }
        // Empty in bottom-right quadrant
        return false;
    }
}
