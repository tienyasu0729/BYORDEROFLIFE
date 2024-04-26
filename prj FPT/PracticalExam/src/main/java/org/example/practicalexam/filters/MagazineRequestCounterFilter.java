package org.example.practicalexam.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/Magazine.jsp")
public class MagazineRequestCounterFilter implements Filter {
    private int hitCount;

    public void init(FilterConfig config) throws ServletException {
        hitCount = 0;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            hitCount++;
            request.setAttribute("hitCount", hitCount);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}

