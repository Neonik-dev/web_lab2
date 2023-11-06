package se.ifmo.web.hard_lab2.utils;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MapperRequestBodyToDirtyPoint {
    public static DirtyPoint mapper(ServletRequest request) throws IOException {
        String requestBody = readDataFromRequest(request);
        Map<String, String> params = parseDataLine(requestBody);
        return new DirtyPoint(params.get("x"), params.get("y"), params.get("r"));
    }

    private static String readDataFromRequest(ServletRequest request) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line = reader.readLine();
        while (line != null) {
            requestBody.append(line);
            line = reader.readLine();
        }
        return requestBody.toString();
    }

    private static Map<String, String> parseDataLine(String requestBody) {
        Map<String, String> params = new HashMap<>();
        String[] paramsLine = requestBody.split("&");
        for (String paramLine : paramsLine) {
            String[] arr = paramLine.split("=");
            params.put(arr[0], arr[1]);
        }
        return params;
    }
}
