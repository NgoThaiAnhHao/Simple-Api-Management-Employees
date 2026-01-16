package com.springlove.simple_management_employee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(config ->
            config
                    // Create User (Register)
                    .requestMatchers(HttpMethod.POST, "/api/users").permitAll()

                    // ================= FOR USER ROLE =================
                    .requestMatchers(HttpMethod.GET,
                            // EMPLOYEES
                            "/api/employees",
                            "/api/employees/**",

                            // EMPLOYEE's PROJECT
                            "/api/employees/projects",

                            // PROJECTS
                            "/api/projects/**",
                            "/api/projects",

                            // SKILLS
                            "/api/skills"
                    )
                    .hasRole("USER")

                    // ================= FOR ADMIN ROLE =================
                    .requestMatchers("/api/**").hasRole("ADMIN")

                    .anyRequest().authenticated()
        );

        // Enable http basic
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Disable csrf
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
