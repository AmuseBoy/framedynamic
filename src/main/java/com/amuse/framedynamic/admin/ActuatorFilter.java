package com.amuse.framedynamic.admin;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName ActuatorFilter
 * @Description TODO
 * @Author 刘培振
 * @Date 2022-12-05 18:27
 * @Version 1.0
 */
@WebFilter
@ServletComponentScan
@Component
public class ActuatorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if(request.getRequestURI().contains("/actuator") && !"admin".equals(request.getHeader("admin-server"))){
            throw new RuntimeException("permission denied");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
