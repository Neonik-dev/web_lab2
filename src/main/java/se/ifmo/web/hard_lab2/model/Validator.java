package se.ifmo.web.hard_lab2.model;

import lombok.RequiredArgsConstructor;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;
import se.ifmo.web.hard_lab2.dto.Point;
import se.ifmo.web.hard_lab2.exceptions.InvalidDataExceptions;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Validator {
    private final DirtyPoint dirtyPoint;
    private static final List<Integer> X_VALUES = new ArrayList<>();
    private static final int Y_MAX = 5;
    private static final int Y_MIN = -5;
    private static final int R_MAX = 5;
    private static final int R_MIN = 2;
    private int x;
    private double y;
    private double r;

    static {
        for (int i = -4; i < 5; i++) {
            X_VALUES.add(i);
        }
    }

    public Point validate() throws InvalidDataExceptions {
        checkX();
        checkY();
        checkR();
        return new Point(x, y, r, AreaChecker.isInArea(x, y, r));
    }

    private void checkX() throws InvalidDataExceptions {
        String xText = dirtyPoint.x();
        strCheck(xText, "X");

        try {
            x = Integer.parseInt(xText);
        } catch (NumberFormatException e) {
            throw new InvalidDataExceptions(e.getMessage());
        }

        if (!X_VALUES.contains(x)) {
            throw new InvalidDataExceptions("X is not included in the valid values");
        }
    }

    private void checkY() throws InvalidDataExceptions {
        String yText = dirtyPoint.y();
        strCheck(yText, "Y");

        try {
            y = Double.parseDouble(yText.replaceAll(",", "."));
        } catch (NumberFormatException e) {
            throw new InvalidDataExceptions(e.getMessage());
        }

        if (y < Y_MIN || y > Y_MAX) {
            throw new InvalidDataExceptions("Y is not included in the valid values");
        }
    }

    private void checkR() throws InvalidDataExceptions {
        String rText = dirtyPoint.r();
        strCheck(rText, "R");

        try {
            r = Double.parseDouble(rText.replaceAll(",", "."));
        } catch (NumberFormatException e) {
            throw new InvalidDataExceptions(e.getMessage());
        }

        if (r < R_MIN || r > R_MAX) {
            throw new InvalidDataExceptions("R is not included in the valid values");
        }
    }

    private void strCheck(String input, String name) throws InvalidDataExceptions {
        if (input == null || input.isEmpty()) {
            throw new InvalidDataExceptions(name + " is an empty value");
        }
        if (input.length() > 6) {
            throw new InvalidDataExceptions(name + " is too long");
        }
    }
}
