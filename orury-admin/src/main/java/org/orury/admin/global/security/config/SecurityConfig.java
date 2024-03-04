package org.orury.admin.global.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.orury.admin.global.security.dto.login.response.AdminPrincipal;
import org.orury.domain.admin.domain.dto.AdminDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.orury.domain.admin.domain.dto.RoleType.ADMIN;
import static org.orury.domain.admin.domain.dto.RoleType.USER;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/admins/**", "/notices/**", "/api/v1/admins/**", "/api/v1/notices/**").hasAuthority(ADMIN.getRoleName())
                        .requestMatchers("/api/v1/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .defaultSuccessUrl("/notices")
                        .failureUrl("/login?error").permitAll()
                )
                .logout(logout -> logout.logoutSuccessUrl("/login"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //역직렬화 에러로 임시 하드 코딩
        return username -> {
            var roles = Set.of(USER, ADMIN);
            var admin = AdminDto.of(1L, "chan", "chan", "{noop}123", roles);
            return AdminPrincipal.from(admin);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    public CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000", "https://f1-orury-client.vercel.app/", "https://orury.com")); // 허용할 origin
            config.setAllowCredentials(true);
            return config;
        };
    }
}