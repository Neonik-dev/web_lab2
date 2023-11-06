package se.ifmo.web.hard_lab2.dto;

import java.io.Serializable;

public record Point(int x, double y, double r, boolean isInArea) implements Serializable {
}
