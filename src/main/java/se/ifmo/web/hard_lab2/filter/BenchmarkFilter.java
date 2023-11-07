package se.ifmo.web.hard_lab2.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import se.ifmo.web.hard_lab2.dto.Benchmarks;
import se.ifmo.web.hard_lab2.utils.ErrorPrinter;

import java.io.IOException;

@WebFilter("/server/*")
public class BenchmarkFilter implements Filter {
    public static final String BENCHMARK_DATA = "benchmarks";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException {
        try {
            long startTime = System.nanoTime();

            filterChain.doFilter(servletRequest, servletResponse);

            long endTime = System.nanoTime();
            Benchmarks benchmarks = (Benchmarks) servletRequest.getServletContext().getAttribute(BENCHMARK_DATA);
            if (benchmarks == null) {
                benchmarks = new Benchmarks();
            }

            String path = ((HttpServletRequest) servletRequest).getServletPath();
            benchmarks.updateTime(endTime - startTime, path);
        } catch (IOException e) {
            ErrorPrinter.print((HttpServletResponse) servletResponse, e.getMessage());
        }
    }
}
