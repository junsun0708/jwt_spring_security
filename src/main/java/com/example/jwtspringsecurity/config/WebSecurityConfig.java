package com.example.jwtspringsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;
import com.example.jwtspringsecurity.jwt.JwtAccessDeniedHandler;
import com.example.jwtspringsecurity.jwt.JwtAuthenticationEntryPoint;
import com.example.jwtspringsecurity.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;

//참고 : https://velog.io/@juno0713/Spring-Security-JWT-React-w3wpg5yi
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig {

  private final TokenProvider tokenProvider;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //http에서 사용하기 위해
    http.httpBasic().disable().csrf().disable().sessionManagement()
    //http.httpBasic().and().csrf().disable().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
        .accessDeniedHandler(jwtAccessDeniedHandler)
        .and().authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated()
        .and().apply(new JwtSecurityConfig(tokenProvider));

    return http.build();
  }
}
