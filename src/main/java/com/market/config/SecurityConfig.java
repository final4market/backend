package com.market.config;

import com.market.filter.JwtRequestFilter;
import com.market.service.CustomUserDetailsService;

import jakarta.annotation.PostConstruct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private final CustomUserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(request -> {
                var corsConfig = new CorsConfiguration();
                corsConfig.setAllowedOrigins(List.of("https://lucky4market.vercel.app", "https://nid.naver.com/oauth2.0/authorize", "https://kauth.kakao.com/oauth/authorize"));
                corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                corsConfig.setAllowedHeaders(List.of("*"));
                corsConfig.setAllowCredentials(true);
                return corsConfig;
            }))
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/auth/**", "/file/**", "/api/product/**", "/api/member/**", "/product/insert", "/api/product/update", "/api/seller/**").permitAll() //전체 허용
                    .requestMatchers(HttpMethod.GET, "/images/**").permitAll() // GET 리퀘스트 전체 허용
                    .requestMatchers(HttpMethod.POST, "/images/**").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(HttpMethod.PUT, "/images/**").hasAnyRole("ADMIN", "USER") // PUT 리퀘스트 관리자, 일반회원 허용
                    .requestMatchers(HttpMethod.DELETE, "/images/**").hasAnyRole("ADMIN", "USER") // DELETE 리퀘스트 관리자, 일반회원 허용
                    .requestMatchers("/admin/**").hasRole("ADMIN") //관리자만 사용
                   

                    .requestMatchers("/**").permitAll() // Allow all requests
                    .anyRequest().authenticated()
                )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Ensure JWT filter is not added
           .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
