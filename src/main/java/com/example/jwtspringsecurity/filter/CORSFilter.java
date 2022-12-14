package com.example.jwtspringsecurity.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CORSFilter implements Filter {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    HttpServletResponse response = (HttpServletResponse) res;
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Allow-Max-Age", "3600");
    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, "
        + "Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
    response.setHeader("Access-Control-Expose-Headers", "X-Total-Count");

    chain.doFilter(req, res);
  }

  public void init(FilterConfig filterConfig) {}

  public void destory() {}
}
