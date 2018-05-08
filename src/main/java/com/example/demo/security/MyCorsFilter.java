package com.example.demo.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.example.demo.security.SecurityConstants.HEADER_STRING;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyCorsFilter implements Filter{

    public MyCorsFilter () {
        super();
    }



    @Override
    public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");

        // without this header jquery.ajax calls returns 401 even after successful login and SSESSIONID being succesfully stored.
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Access-Control-Allow-Origin, Content-Type, id");
        response.setHeader("Access-Control-Expose-Headers", HEADER_STRING);

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}