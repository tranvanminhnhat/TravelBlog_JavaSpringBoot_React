package com.travel.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Tắt CSRF nếu dùng REST API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/google").permitAll() // ✅ Cho phép truy cập không cần đăng nhập
                        .anyRequest().authenticated()               // Các endpoint khác phải đăng nhập
                )
                .httpBasic(Customizer.withDefaults()); // hoặc cấu hình formLogin, jwt, v.v.

        return http.build();
    }
}
