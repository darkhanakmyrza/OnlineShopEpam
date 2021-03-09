package com.epam.onlineShop.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharSetFilter implements Filter {
    private String encoding;
    private ServletContext context;

    public CharSetFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        this.context.log("charset set.");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.encoding = fConfig.getInitParameter("characterEncoding");
        this.context = fConfig.getServletContext();
    }
}
