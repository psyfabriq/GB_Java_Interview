package ru.psyfabriq.filters;

import javax.servlet.*;
import java.io.IOException;

public class UTF8Filter implements Filter {

    @Override
    public void init(FilterConfig fConfig) {
        System.out.println("UTF8Filter init!");
    }

    @Override
    public void destroy() {
        System.out.println("UTF8Filter destroy!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}

