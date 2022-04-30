package com.liduoan.backend.config.header;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CustomHttpServletRequest request=new CustomHttpServletRequest((HttpServletRequest) servletRequest);
        BackResult<Claims> result = JwtUtil.validateJWT(request.getHeader("token"));
        request.addHeader("userId",result.getData().getSubject());
        filterChain.doFilter(request,servletResponse);
    }

}