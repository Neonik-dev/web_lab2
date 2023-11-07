package se.ifmo.web.hard_lab2.dto;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Benchmarks {
    private final Map<String, Long> benchmarks = new HashMap<>();

    public void updateTime(long time, String path) {
        synchronized (benchmarks) {
            benchmarks.merge(path, time, Math::min);
        }
    }
}
