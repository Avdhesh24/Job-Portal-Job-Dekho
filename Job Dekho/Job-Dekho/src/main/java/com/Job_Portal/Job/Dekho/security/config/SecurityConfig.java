package com.Job_Portal.Job.Dekho.security.config;

import com.Job_Portal.Job.Dekho.security.jwt.JwtGeneratorFilter;
import com.Job_Portal.Job.Dekho.security.jwt.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private JwtValidationFilter jwtValidationFilter;

    @Autowired
    private JwtGeneratorFilter jwtGeneratorFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/users/register", "/api/users/login").permitAll()


                        .requestMatchers("/api/profiles").hasRole("JOB_SEEKER")
                        .requestMatchers("/api/jobs").hasAnyRole("JOB_SEEKER", "EMPLOYER")
                        .requestMatchers("/api/applications").hasAnyRole("JOB_SEEKER", "EMPLOYER")
                        .requestMatchers("/api/notifications").hasAnyRole("JOB_SEEKER", "EMPLOYER")

                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtValidationFilter, BasicAuthenticationFilter.class)
                .addFilterAfter(jwtGeneratorFilter, BasicAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
